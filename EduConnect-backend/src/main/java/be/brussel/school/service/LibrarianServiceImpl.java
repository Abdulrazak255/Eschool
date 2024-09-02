package be.brussel.school.service;

import be.brussel.school.model.Librarian;
import be.brussel.school.repository.LibrarianRepository;
import be.brussel.school.service.LibrarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibrarianServiceImpl implements LibrarianService {

    private final LibrarianRepository librarianRepository;

    @Override
    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }

    @Override
    public Optional<Librarian> getLibrarianById(Long id) {
        return librarianRepository.findById(id);
    }

    @Override
    public Librarian saveLibrarian(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    @Override
    public Librarian updateLibrarian(Long id, Librarian librarian) {
        if (librarianRepository.existsById(id)) {
            librarian.setId(id);
            return librarianRepository.save(librarian);
        }
        return null;
    }

    @Override
    public void deleteLibrarian(Long id) {
        librarianRepository.deleteById(id);
    }
}
