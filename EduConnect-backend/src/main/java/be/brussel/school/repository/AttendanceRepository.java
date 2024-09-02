package be.brussel.school.repository;

import be.brussel.school.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByStudentId(Long studentId);

    // Removed incorrect queries and retained the correct one
    List<Attendance> findByClassEntityId(Long classId);

    List<Attendance> findByDate(LocalDate date);

    List<Attendance> findByStudentIdAndDate(Long studentId, LocalDate date);

    // Removed incorrect methods related to teacher or unnecessary path traversals
}
