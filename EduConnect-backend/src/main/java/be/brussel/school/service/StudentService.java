package be.brussel.school.service;

import be.brussel.school.model.Student;
import be.brussel.school.model.Subject;
import be.brussel.school.model.Grade;
import be.brussel.school.model.ClassSchedule;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student saveStudent(Student student);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
    List<Subject> getSubjectsByStudentId(Long studentId);
    List<Grade> getGradesByStudentId(Long studentId);
    ClassSchedule getClassScheduleByStudentId(Long studentId);
    Optional<Student> getStudentsByParentId(Long parentId);
}
