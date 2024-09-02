package be.brussel.school.service;

import be.brussel.school.model.ClassSchedule;
import be.brussel.school.model.Lesson;
import be.brussel.school.repository.ClassScheduleRepository;
import be.brussel.school.repository.LessonRepository;
import be.brussel.school.service.ClassScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassScheduleServiceImpl implements ClassScheduleService {

    private final ClassScheduleRepository classScheduleRepository;
    private final LessonRepository lessonRepository;

    @Override
    public List<ClassSchedule> getAllClassSchedules() {
        return classScheduleRepository.findAll();
    }

    @Override
    public Optional<ClassSchedule> getClassScheduleById(Long id) {
        return classScheduleRepository.findById(id);
    }

    @Override
    public ClassSchedule saveClassSchedule(ClassSchedule classSchedule) {
        return classScheduleRepository.save(classSchedule);
    }

    @Override
    public void deleteClassSchedule(Long id) {
        classScheduleRepository.deleteById(id);
    }

    @Override
    public List<Lesson> getLessonsByClassSchedule(Long classScheduleId) {
        Optional<ClassSchedule> classSchedule = classScheduleRepository.findById(classScheduleId);
        return classSchedule.map(ClassSchedule::getLessons).orElse(null);
    }

    @Override
    public List<Lesson> getLessonsByTeacherId(Long teacherId) {
        return lessonRepository.findByTeacherId(teacherId);
    }

    @Override
    public Optional<ClassSchedule> getClassScheduleByClassId(Long classId) {
        return classScheduleRepository.findByClassEntityId(classId);
    }

    @Override
    public ClassSchedule updateClassSchedule(Long scheduleId, ClassSchedule classSchedule) {
        // Implement the update logic if needed
        return null;
    }
}
