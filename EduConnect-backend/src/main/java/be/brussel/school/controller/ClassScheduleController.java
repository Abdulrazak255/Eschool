package be.brussel.school.controller;

import be.brussel.school.model.ClassSchedule;
import be.brussel.school.model.Lesson;
import be.brussel.school.service.ClassScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/class-schedules")
@RequiredArgsConstructor
public class ClassScheduleController {

    private final ClassScheduleService classScheduleService;

    @GetMapping
    public ResponseEntity<List<ClassSchedule>> getAllClassSchedules() {
        return ResponseEntity.ok(classScheduleService.getAllClassSchedules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassSchedule> getClassScheduleById(@PathVariable Long id) {
        Optional<ClassSchedule> classSchedule = classScheduleService.getClassScheduleById(id);
        return classSchedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClassSchedule> createClassSchedule(@RequestBody ClassSchedule classSchedule) {
        return ResponseEntity.ok(classScheduleService.saveClassSchedule(classSchedule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassSchedule> updateClassSchedule(@PathVariable Long id,
                                                             @RequestBody ClassSchedule classSchedule) {
        ClassSchedule updatedClassSchedule = classScheduleService.updateClassSchedule(id, classSchedule);
        if (updatedClassSchedule != null) {
            return ResponseEntity.ok(updatedClassSchedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassSchedule(@PathVariable Long id) {
        classScheduleService.deleteClassSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{classScheduleId}/lessons")
    public ResponseEntity<List<Lesson>> getLessonsByClassSchedule(@PathVariable Long classScheduleId) {
        return ResponseEntity.ok(classScheduleService.getLessonsByClassSchedule(classScheduleId));
    }

    @GetMapping("/teacher/{teacherId}/lessons")
    public ResponseEntity<List<Lesson>> getLessonsByTeacherId(@PathVariable Long teacherId) {
        return ResponseEntity.ok(classScheduleService.getLessonsByTeacherId(teacherId));
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<Optional<ClassSchedule>> getClassScheduleByClassId(@PathVariable Long classId) {
        return ResponseEntity.ok(classScheduleService.getClassScheduleByClassId(classId));
    }
}
