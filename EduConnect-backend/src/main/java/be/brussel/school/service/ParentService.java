package be.brussel.school.service;

import be.brussel.school.model.Parent;
import be.brussel.school.model.Student;
import be.brussel.school.model.Subject;
import be.brussel.school.model.Grade;
import be.brussel.school.model.ClassSchedule;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    List<Parent> getAllParents();
    Optional<Parent> getParentById(Long id);

    List<Parent> findParentsByStudentId(Long studentId);

    Parent saveParent(Parent parent);
    Parent updateParent(Long id, Parent parent);
    void deleteParent(Long id);
    Optional<Student> getStudentProfile(Long parentId);
    List<Subject> getStudentSubjects(Long parentId);
    List<Grade> getStudentGrades(Long parentId);
    ClassSchedule getStudentClassSchedule(Long parentId);
    void contactTeacher(Long parentId, Long teacherId, String message);
}
