package be.brussel.school.service;

import be.brussel.school.model.Student;
import be.brussel.school.model.Subject;
import be.brussel.school.model.Grade;
import be.brussel.school.model.ClassSchedule;
import be.brussel.school.repository.StudentRepository;
import be.brussel.school.repository.GradeRepository;
import be.brussel.school.repository.ClassScheduleRepository;
import be.brussel.school.repository.SubjectRepository;
import be.brussel.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final GradeRepository gradeRepository;
    private final ClassScheduleRepository classScheduleRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Subject> getSubjectsByStudentId(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.map(s -> subjectRepository.findByClassesId(s.getStudentClass().getId())).orElse(null);
    }

    @Override
    public List<Grade> getGradesByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public ClassSchedule getClassScheduleByStudentId(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.map(s -> classScheduleRepository.findByClassEntityId(s.getStudentClass().getId())
                .orElseThrow(() -> new RuntimeException("Class schedule not found"))).orElse(null);
    }

    @Override
    public Optional<Student> getStudentsByParentId(Long parentId) {
        return studentRepository.findByParentsId(parentId);
    }
}
