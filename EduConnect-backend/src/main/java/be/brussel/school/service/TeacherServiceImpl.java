package be.brussel.school.service;

import be.brussel.school.model.*;
import be.brussel.school.model.Class;
import be.brussel.school.repository.*;
import be.brussel.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final AttendanceRepository attendanceRepository;
    private final GradeRepository gradeRepository;
    private final ClassRepository classRepository;
    private final ClassScheduleRepository classScheduleRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        if (teacherRepository.existsById(id)) {
            teacher.setId(id);
            return teacherRepository.save(teacher);
        }
        return null;
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<Class> getClassesByTeacher(Long teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        return teacher.map(t -> new ArrayList<>(t.getClasses())).orElse(null);
    }

    @Override
    public List<Subject> getSubjectsByTeacher(Long teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        return teacher.map(t -> new ArrayList<>(t.getSubjects())).orElse(null);
    }

    @Override
    public List<Student> getStudentsByClass(Long classId) {
        Optional<Class> classEntity = classRepository.findById(classId);
        return classEntity.map(clazz -> new ArrayList<>(clazz.getStudents())).orElse(null);
    }

    @Override
    public List<Grade> getGradesByStudent(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public Grade addOrUpdateGrade(Long teacherId, Long studentId, Long subjectId, Grade grade) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Subject> subject = subjectRepository.findById(subjectId);

        if (teacher.isPresent() && student.isPresent() && subject.isPresent()) {
            grade.setTeacher(teacher.get());
            grade.setStudent(student.get());
            grade.setSubject(subject.get());

            double testAverage = (grade.getFirstTest() + grade.getSecondTest()) / 2;
            double examAverage = (grade.getFirstExam() + grade.getSecondExam()) / 2;
            grade.setAverage((testAverage + examAverage) / 2);

            return gradeRepository.save(grade);
        }
        return null;
    }

    @Override
    public List<Attendance> getAttendanceByClass(Long classId) {
        return attendanceRepository.findByClassEntityId(classId);
    }

    @Override
    public void recordAttendance(Long classId, Long studentId, boolean isPresent) {
        // Fetch the class entity using the class ID
        Class classEntity = classRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found with id: " + classId));

        // Fetch the student entity using the student ID
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        // Create a new Attendance object
        Attendance attendance = new Attendance();
        attendance.setClassEntity(classEntity); // Set the unwrapped Class entity
        attendance.setStudent(student);         // Set the Student entity
        attendance.setPresent(isPresent);       // Set the attendance status
        attendance.setDate(LocalDate.now());    // Set the date to the current date

        // Save the attendance record to the repository
        attendanceRepository.save(attendance);
    }

    @Override
    public void contactParent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            // Logic to contact the parent (e.g., send an email)
        }
    }

    @Override
    public void contactManager(Long teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        if (teacher.isPresent()) {
            // Logic to contact the manager (e.g., send an email)
        }
    }

    @Override
    public List<ClassSchedule> getClassSchedulesForTeacher(Long teacherId) {
        return classScheduleRepository.findByLessonsTeacherId(teacherId);
    }
}
