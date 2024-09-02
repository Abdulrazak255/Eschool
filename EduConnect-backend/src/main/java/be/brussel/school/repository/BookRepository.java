package be.brussel.school.repository;

import be.brussel.school.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
    Optional<Book> findByBarcode(String barcode);
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByLibrarianId(Long librarianId);
}
