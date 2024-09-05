package be.brussel.school.controller;

import be.brussel.school.model.Grade;
import be.brussel.school.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> grades = gradeService.getAllGrades();
        return ResponseEntity.ok(grades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        Optional<Grade> grade = gradeService.getGradeById(id);
        return grade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        Grade newGrade = gradeService.saveGrade(grade);
        return ResponseEntity.ok(newGrade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody Grade grade) {
        Grade updatedGrade = gradeService.updateGrade(id, grade);
        if (updatedGrade != null) {
            return ResponseEntity.ok(updatedGrade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Grade>> getGradesByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(gradeService.getGradesByStudentId(studentId));
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<Grade>> getGradesBySubjectId(@PathVariable Long subjectId) {
        return ResponseEntity.ok(gradeService.getGradesBySubjectId(subjectId));
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<Grade>> getGradesByTeacherId(@PathVariable Long teacherId) {
        return ResponseEntity.ok(gradeService.getGradesByTeacherId(teacherId));
    }
}
