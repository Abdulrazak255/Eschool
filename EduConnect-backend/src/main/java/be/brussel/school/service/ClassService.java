package be.brussel.school.service;

import be.brussel.school.model.Class;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    List<Class> getAllClasses();
    Optional<Class> getClassById(Long id);
    Class saveClass(Class schoolClass);
    Class updateClass(Long id, Class schoolClass);
    void deleteClass(Long id);
}
