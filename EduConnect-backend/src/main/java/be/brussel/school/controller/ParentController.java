package be.brussel.school.controller;

import be.brussel.school.model.Parent;
import be.brussel.school.model.Student;
import be.brussel.school.model.Subject;
import be.brussel.school.model.Grade;
import be.brussel.school.model.ClassSchedule;
import be.brussel.school.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parents")
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;

    @GetMapping
    public ResponseEntity<List<Parent>> getAllParents() {
        return ResponseEntity.ok(parentService.getAllParents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable Long id) {
        Optional<Parent> parent = parentService.getParentById(id);
        return parent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent) {
        return ResponseEntity.ok(parentService.saveParent(parent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parent> updateParent(@PathVariable Long id, @RequestBody Parent parent) {
        Parent updatedParent = parentService.updateParent(id, parent);
        if (updatedParent != null) {
            return ResponseEntity.ok(updatedParent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{parentId}/student")
    public ResponseEntity<Optional<Student>> getStudentProfile(@PathVariable Long parentId) {
        return ResponseEntity.ok(parentService.getStudentProfile(parentId));
    }

    @GetMapping("/{parentId}/student/subjects")
    public ResponseEntity<List<Subject>> getStudentSubjects(@PathVariable Long parentId) {
        return ResponseEntity.ok(parentService.getStudentSubjects(parentId));
    }

    @GetMapping("/{parentId}/student/grades")
    public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable Long parentId) {
        return ResponseEntity.ok(parentService.getStudentGrades(parentId));
    }

    @GetMapping("/{parentId}/student/schedule")
    public ResponseEntity<ClassSchedule> getStudentClassSchedule(@PathVariable Long parentId) {
        return ResponseEntity.ok(parentService.getStudentClassSchedule(parentId));
    }

    @PostMapping("/{parentId}/contact-teacher/{teacherId}")
    public ResponseEntity<Void> contactTeacher(@PathVariable Long parentId,
                                               @PathVariable Long teacherId,
                                               @RequestBody String message) {
        parentService.contactTeacher(parentId, teacherId, message);
        return ResponseEntity.noContent().build();
    }
}
