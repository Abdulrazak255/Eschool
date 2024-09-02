package be.brussel.school.service;

import be.brussel.school.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> getAllSubjects();
    Optional<Subject> getSubjectById(Long id);
    Subject saveSubject(Subject subject);
    Subject updateSubject(Long id, Subject subject);
    void deleteSubject(Long id);
}
