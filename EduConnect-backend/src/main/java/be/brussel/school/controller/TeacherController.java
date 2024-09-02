package be.brussel.school.controller;

import be.brussel.school.model.Teacher;
import be.brussel.school.model.Class;
import be.brussel.school.model.Subject;
import be.brussel.school.model.Student;
import be.brussel.school.model.Grade;
import be.brussel.school.model.Attendance;
import be.brussel.school.model.ClassSchedule;
import be.brussel.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        return ResponseEntity.ok(teacherService.saveTeacher(teacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
        if (updatedTeacher != null) {
            return ResponseEntity.ok(updatedTeacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{teacherId}/classes")
    public ResponseEntity<List<Class>> getClassesByTeacher(@PathVariable Long teacherId) {
        return ResponseEntity.ok(teacherService.getClassesByTeacher(teacherId));
    }

    @GetMapping("/{teacherId}/subjects")
    public ResponseEntity<List<Subject>> getSubjectsByTeacher(@PathVariable Long teacherId) {
        return ResponseEntity.ok(teacherService.getSubjectsByTeacher(teacherId));
    }

    @GetMapping("/classes/{classId}/students")
    public ResponseEntity<List<Student>> getStudentsByClass(@PathVariable Long classId) {
        return ResponseEntity.ok(teacherService.getStudentsByClass(classId));
    }

    @GetMapping("/students/{studentId}/grades")
    public ResponseEntity<List<Grade>> getGradesByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(teacherService.getGradesByStudent(studentId));
    }

    @PostMapping("/{teacherId}/grades")
    public ResponseEntity<Grade> addOrUpdateGrade(@PathVariable Long teacherId,
                                                  @RequestParam Long studentId,
                                                  @RequestParam Long subjectId,
                                                  @RequestBody Grade grade) {
        Grade updatedGrade = teacherService.addOrUpdateGrade(teacherId, studentId, subjectId, grade);
        return ResponseEntity.ok(updatedGrade);
    }

    @GetMapping("/classes/{classId}/attendance")
    public ResponseEntity<List<Attendance>> getAttendanceByClass(@PathVariable Long classId) {
        return ResponseEntity.ok(teacherService.getAttendanceByClass(classId));
    }

    @PostMapping("/classes/{classId}/attendance")
    public ResponseEntity<Void> recordAttendance(@PathVariable Long classId,
                                                 @RequestParam Long studentId,
                                                 @RequestParam boolean isPresent) {
        teacherService.recordAttendance(classId, studentId, isPresent);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/contact/parent/{studentId}")
    public ResponseEntity<Void> contactParent(@PathVariable Long studentId) {
        teacherService.contactParent(studentId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/contact/manager/{teacherId}")
    public ResponseEntity<Void> contactManager(@PathVariable Long teacherId) {
        teacherService.contactManager(teacherId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{teacherId}/schedules")
    public ResponseEntity<List<ClassSchedule>> getClassSchedulesForTeacher(@PathVariable Long teacherId) {
        return ResponseEntity.ok(teacherService.getClassSchedulesForTeacher(teacherId));
    }
}
