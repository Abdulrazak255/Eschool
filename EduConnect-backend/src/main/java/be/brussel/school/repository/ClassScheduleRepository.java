package be.brussel.school.repository;

import be.brussel.school.model.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, Long> {


    List<ClassSchedule> findByLessonsTeacherId(Long teacherId);

    Optional<ClassSchedule> findByClassEntityId(Long classId);

}
