package be.brussel.school.service;

import be.brussel.school.model.ClassSchedule;
import be.brussel.school.model.Lesson;

import java.util.List;
import java.util.Optional;

public interface ClassScheduleService {
    List<ClassSchedule> getAllClassSchedules();
    Optional<ClassSchedule> getClassScheduleById(Long id);
    ClassSchedule saveClassSchedule(ClassSchedule classSchedule);
    void deleteClassSchedule(Long id);
    List<Lesson> getLessonsByClassSchedule(Long classScheduleId);
    List<Lesson> getLessonsByTeacherId(Long teacherId);
    Optional<ClassSchedule> getClassScheduleByClassId(Long classId);
    ClassSchedule updateClassSchedule(Long scheduleId, ClassSchedule classSchedule);
}
