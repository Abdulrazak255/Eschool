package be.brussel.school.repository;

import be.brussel.school.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByDayOfWeek(DayOfWeek dayOfWeek);

    List<Lesson> findByTeacherId(Long teacherId);

    List<Lesson> findBySubjectId(Long subjectId);

    List<Lesson> findByClassScheduleId(Long classScheduleId);
}
