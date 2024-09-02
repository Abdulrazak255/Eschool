package be.brussel.school.repository;

import be.brussel.school.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

    List<Class> findByClassName(String className);
    List<Class> findByClassTeachersId(Long teacherId);

    List<Class> findByYear(int year);
}
