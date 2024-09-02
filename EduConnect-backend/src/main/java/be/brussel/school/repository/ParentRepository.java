package be.brussel.school.repository;

import be.brussel.school.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    List<Parent> findByLastName(String lastName);

    // This method is correct if you want to find parents by associated student ID
    List<Parent> findByStudentsId(Long studentId);

    // Removed the incorrect method
}
