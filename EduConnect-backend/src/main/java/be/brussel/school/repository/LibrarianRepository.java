package be.brussel.school.repository;

import be.brussel.school.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    Optional<Librarian> findByUsername(String username);
    Optional<Librarian> findByEmail(String email);
    Optional<Librarian> findByPhoneNumber(String phoneNumber);
}
