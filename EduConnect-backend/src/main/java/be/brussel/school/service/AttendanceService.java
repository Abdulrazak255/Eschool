package be.brussel.school.service;

import be.brussel.school.model.Attendance;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceService {
    Optional<Attendance> getAttendanceById(Long id);
    List<Attendance> getAttendanceByStudentId(Long studentId);
    List<Attendance> getAttendanceByClassId(Long classId);
    Attendance saveAttendance(Attendance attendance);
    void deleteAttendance(Long id);
    List<Attendance> getAttendanceByDate(LocalDate date);

    void markAttendance(Long studentId, Long classId, LocalDate date, boolean present);
}
