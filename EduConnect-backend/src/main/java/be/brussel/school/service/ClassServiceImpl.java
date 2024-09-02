package be.brussel.school.service;

import be.brussel.school.model.Class;
import be.brussel.school.repository.ClassRepository;
import be.brussel.school.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    @Override
    public List<Class> getAllClasses() {
        List<Class> classes = classRepository.findAll();
        classes.forEach(c -> {
            c.setSubjects(null);
            c.setStudents(null);
            c.setClassTeachers(null); // Ensure you are using the correct field
        });
        return classes;
    }

    @Override
    public Optional<Class> getClassById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public Class saveClass(Class schoolClass) {
        return classRepository.save(schoolClass);
    }

    @Override
    public Class updateClass(Long id, Class schoolClass) {
        if (classRepository.existsById(id)) {
            schoolClass.setId(id);
            return classRepository.save(schoolClass);
        }
        return null;
    }

    @Override
    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}
