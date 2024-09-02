package be.brussel.school.repository;

import be.brussel.school.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    List<Manager> findByManagedDepartmentsContaining(String department);

    List<Manager> findByLastName(String lastName);

    boolean existsByManagedDepartments(String managedDepartments);
}
