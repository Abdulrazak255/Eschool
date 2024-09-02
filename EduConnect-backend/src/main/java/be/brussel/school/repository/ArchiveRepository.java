package be.brussel.school.repository;

import be.brussel.school.model.Archive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchiveRepository extends JpaRepository<Archive, Long> {

    List<Archive> findByTitleContaining(String title) ;

    List<Archive> findByArchivedById(Long userId);
}
