package be.brussel.school.service;

import be.brussel.school.model.Librarian;

import java.util.List;
import java.util.Optional;

public interface LibrarianService {
    List<Librarian> getAllLibrarians();
    Optional<Librarian> getLibrarianById(Long id);
    Librarian saveLibrarian(Librarian librarian);
    Librarian updateLibrarian(Long id, Librarian librarian);
    void deleteLibrarian(Long id);
}
