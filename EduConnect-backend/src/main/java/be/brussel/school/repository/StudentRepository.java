package be.brussel.school.repository;

import be.brussel.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByEnrollmentYear(String enrollmentYear);

    List<Student> findByGrade(String grade);

    List<Student> findByLastName(String lastName);

    List<Student> findByStudentClassId(Long classId);

    Optional<Student> findByParentsId(Long parentId);
}
