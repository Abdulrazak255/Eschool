package be.brussel.school.service;

import be.brussel.school.model.Attendance;
import be.brussel.school.model.Student;
import be.brussel.school.model.Class;
import be.brussel.school.repository.AttendanceRepository;
import be.brussel.school.repository.StudentRepository;
import be.brussel.school.repository.ClassRepository;
import be.brussel.school.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    @Override
    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public List<Attendance> getAttendanceByStudentId(Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

    @Override
    public List<Attendance> getAttendanceByClassId(Long classId) {
        return attendanceRepository.findByClassEntityId(classId);
    }

    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    @Override
    public List<Attendance> getAttendanceByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }





    @Override
    public void markAttendance(Long studentId, Long classId, LocalDate date, boolean present) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        Class classEntity = classRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found with id: " + classId));

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setClassEntity(classEntity);
        attendance.setDate(date);
        attendance.setPresent(present);

        attendanceRepository.save(attendance);
    }
}
