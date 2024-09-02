package be.brussel.school.controller;

import be.brussel.school.model.Student;
import be.brussel.school.model.Subject;
import be.brussel.school.model.Grade;
import be.brussel.school.model.ClassSchedule;
import be.brussel.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{studentId}/subjects")
    public ResponseEntity<List<Subject>> getSubjectsByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.getSubjectsByStudentId(studentId));
    }

    @GetMapping("/{studentId}/grades")
    public ResponseEntity<List<Grade>> getGradesByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.getGradesByStudentId(studentId));
    }

    @GetMapping("/{studentId}/schedule")
    public ResponseEntity<ClassSchedule> getClassScheduleByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.getClassScheduleByStudentId(studentId));
    }

    @GetMapping("/parent/{parentId}")
    public ResponseEntity<Optional<Student>> getStudentsByParentId(@PathVariable Long parentId) {
        return ResponseEntity.ok(studentService.getStudentsByParentId(parentId));
    }
}
