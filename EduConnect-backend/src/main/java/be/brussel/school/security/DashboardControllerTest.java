package be.brussel.school.security;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardControllerTest {



    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("/teacher")
    public ResponseEntity<?> getTeacherDashboard() {
        // Logic specific to teacher's dashboard
        String teacherDashboard = "Welcome to the Teacher Dashboard! Here you can manage your classes, view student progress, and more.";
        return ResponseEntity.ok(teacherDashboard);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping("/manager")
    public ResponseEntity<?> getManagerDashboard() {
        // Logic specific to manager's dashboard
        String managerDashboard = "Welcome to the Manager Dashboard! Here you can oversee school operations, manage staff, and more.";
        return ResponseEntity.ok(managerDashboard);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/student")
    public ResponseEntity<?> getStudentDashboard() {
        // Logic specific to student's dashboard
        String studentDashboard = "Welcome to the Student Dashboard! Here you can view your grades, class schedules, and more.";
        return ResponseEntity.ok(studentDashboard);
    }

    @PreAuthorize("hasRole('PARENT')")
    @GetMapping("/parent")
    public ResponseEntity<?> getParentDashboard() {
        // Logic specific to parent's dashboard
        String parentDashboard = "Welcome to the Parent Dashboard! Here you can monitor your child's progress, communicate with teachers, and more.";
        return ResponseEntity.ok(parentDashboard);
    }
}
