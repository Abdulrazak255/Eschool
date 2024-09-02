package be.brussel.school.service;

import be.brussel.school.model.Archive;

import java.util.List;
import java.util.Optional;

public interface ArchiveService {
    List<Archive> getAllArchives();
    Optional<Archive> getArchiveById(Long id);
    Archive saveArchive(Archive archive);
    Archive updateArchive(Long id, Archive archive);
    void deleteArchive(Long id);
}
