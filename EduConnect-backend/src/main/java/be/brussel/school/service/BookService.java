package be.brussel.school.service;

import be.brussel.school.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book addBook(Book book);
    List<Book> getAllBooks();
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
    Optional<Book> findBookByIsbn(String isbn);
    Optional<Book> findBookByBarcode(String barcode);
    List<Book> searchBooksByTitle(String title);
    List<Book> getBooksByLibrarian(Long librarianId);
}
