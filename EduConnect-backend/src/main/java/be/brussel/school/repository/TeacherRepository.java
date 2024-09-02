package be.brussel.school.repository;

import be.brussel.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByDepartment(String department);

    List<Teacher> findBySubject(String subject);

    List<Teacher> findByLastName(String lastName);
}
