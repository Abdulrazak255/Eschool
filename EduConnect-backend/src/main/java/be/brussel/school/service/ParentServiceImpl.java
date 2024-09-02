package be.brussel.school.service;

import be.brussel.school.model.*;
import be.brussel.school.repository.*;
import be.brussel.school.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final ClassScheduleRepository classScheduleRepository;
    private final GradeRepository gradeRepository;

    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public Optional<Parent> getParentById(Long id) {
        return parentRepository.findById(id);
    }

    @Override
    public List<Parent> findParentsByStudentId(Long studentId) {
        return parentRepository.findByStudentsId(studentId);
    }

    @Override
    public Parent saveParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public Parent updateParent(Long id, Parent parent) {
        if (parentRepository.existsById(id)) {
            parent.setId(id);
            return parentRepository.save(parent);
        }
        return null;
    }

    @Override
    public void deleteParent(Long id) {
        parentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> getStudentProfile(Long parentId) {
        Optional<Parent> parentOptional = parentRepository.findById(parentId);
        if (parentOptional.isPresent()) {
            Set<Student> students = parentOptional.get().getStudents();
            if (!students.isEmpty()) {
                return Optional.of(students.iterator().next()); // Return the first student or a list of students as needed
            }
        }
        return Optional.empty(); // If no student is found
    }

    @Override
    public List<Subject> getStudentSubjects(Long parentId) {
        Optional<Student> studentOptional = studentRepository.findById(parentId);
        if (studentOptional.isPresent()) {
            Long classId = studentOptional.get().getStudentClass().getId();
            return subjectRepository.findByClassesId(classId);
        } else {
            throw new RuntimeException("Student not found for parentId: " + parentId);
        }
    }

    @Override
    public List<Grade> getStudentGrades(Long parentId) {
        Optional<Student> studentOptional = studentRepository.findById(parentId);
        if (studentOptional.isPresent()) {
            return gradeRepository.findByStudentId(studentOptional.get().getId());
        } else {
            throw new RuntimeException("Student not found for parentId: " + parentId);
        }
    }

    @Override
    public ClassSchedule getStudentClassSchedule(Long parentId) {
        Optional<Student> studentOptional = studentRepository.findById(parentId);
        if (studentOptional.isPresent()) {
            Long classId = studentOptional.get().getStudentClass().getId();
            return classScheduleRepository.findByClassEntityId(classId)
                    .orElseThrow(() -> new RuntimeException("Class schedule not found for class id: " + classId));
        } else {
            throw new RuntimeException("Student not found for parentId: " + parentId);
        }
    }

    @Override
    public void contactTeacher(Long parentId, Long teacherId, String message) {
        Optional<Student> studentOptional = studentRepository.findById(parentId);
        Optional<Teacher> teacherOptional = teacherRepository.findById(teacherId);

        if (studentOptional.isPresent() && teacherOptional.isPresent()) {
            // Logic to contact the teacher, such as sending an email or saving the message in the database
            System.out.println("Message from parent (ID: " + parentId + ") to teacher (ID: " + teacherId + "): " + message);
        } else {
            throw new RuntimeException("Either student or teacher not found for provided IDs.");
        }
    }
}
