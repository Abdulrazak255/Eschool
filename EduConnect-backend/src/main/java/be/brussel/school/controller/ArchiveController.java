package be.brussel.school.controller;

import be.brussel.school.model.Archive;
import be.brussel.school.service.ArchiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/archives")
@RequiredArgsConstructor
public class ArchiveController {

    private final ArchiveService archiveService;

    @GetMapping
    public ResponseEntity<List<Archive>> getAllArchives() {
        return ResponseEntity.ok(archiveService.getAllArchives());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Archive> getArchiveById(@PathVariable Long id) {
        Optional<Archive> archive = archiveService.getArchiveById(id);
        return archive.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Archive> createArchive(@RequestBody Archive archive) {
        return ResponseEntity.ok(archiveService.saveArchive(archive));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Archive> updateArchive(@PathVariable Long id, @RequestBody Archive archive) {
        Archive updatedArchive = archiveService.updateArchive(id, archive);
        if (updatedArchive != null) {
            return ResponseEntity.ok(updatedArchive);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArchive(@PathVariable Long id) {
        archiveService.deleteArchive(id);
        return ResponseEntity.noContent().build();
    }
}
