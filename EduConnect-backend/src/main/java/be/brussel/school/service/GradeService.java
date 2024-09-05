package be.brussel.school.service;

import be.brussel.school.model.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeService {
    List<Grade> getAllGrades();
    Optional<Grade> getGradeById(Long id);
    Grade saveGrade(Grade grade);
    Grade updateGrade(Long id, Grade grade);
    void deleteGrade(Long id);
    List<Grade> getGradesByStudentId(Long studentId);
    List<Grade> getGradesBySubjectId(Long subjectId);
    List<Grade> getGradesByTeacherId(Long teacherId);
}

