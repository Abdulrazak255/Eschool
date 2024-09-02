package be.brussel.school.service;

import be.brussel.school.model.*;
import be.brussel.school.model.Class;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Optional<Teacher> getTeacherById(Long id);
    Teacher saveTeacher(Teacher teacher);
    Teacher updateTeacher(Long id, Teacher teacher);
    void deleteTeacher(Long id);
    List<Class> getClassesByTeacher(Long teacherId);
    List<Subject> getSubjectsByTeacher(Long teacherId);
    List<Student> getStudentsByClass(Long classId);
    List<Grade> getGradesByStudent(Long studentId);
    Grade addOrUpdateGrade(Long teacherId, Long studentId, Long subjectId, Grade grade);
    List<Attendance> getAttendanceByClass(Long classId);
    void recordAttendance(Long classId, Long studentId, boolean isPresent);
    void contactParent(Long studentId);
    void contactManager(Long teacherId);
    List<ClassSchedule> getClassSchedulesForTeacher(Long teacherId);
}
