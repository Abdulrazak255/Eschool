package be.brussel.school.service;

import be.brussel.school.model.Archive;
import be.brussel.school.repository.ArchiveRepository;
import be.brussel.school.service.ArchiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArchiveServiceImpl implements ArchiveService {

    private final ArchiveRepository archiveRepository;

    @Override
    public List<Archive> getAllArchives() {
        return archiveRepository.findAll();
    }

    @Override
    public Optional<Archive> getArchiveById(Long id) {
        return archiveRepository.findById(id);
    }

    @Override
    public Archive saveArchive(Archive archive) {
        return archiveRepository.save(archive);
    }

    @Override
    public Archive updateArchive(Long id, Archive archive) {
        if (archiveRepository.existsById(id)) {
            archive.setId(id);
            return archiveRepository.save(archive);
        }
        return null;
    }

    @Override
    public void deleteArchive(Long id) {
        archiveRepository.deleteById(id);
    }
}
