package be.brussel.school.security;


import be.brussel.school.model.User;
import be.brussel.school.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    public JwtAuthenticationController(AuthenticationService authenticationService, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        String jwt = authenticationService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Logout successful. Please delete the token client-side.");
    }

    @PostMapping("/register/teacher")
    public ResponseEntity<User> registerTeacher(@RequestBody User user) {
        User registeredUser = authenticationService.registerTeacher(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/register/manager")
    public ResponseEntity<User> registerManager(@RequestBody User user) {
        User registeredUser = authenticationService.registerManager(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/register/student")
    public ResponseEntity<User> registerStudent(@RequestBody User user) {
        User registeredUser = authenticationService.registerStudent(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/register/parent")
    public ResponseEntity<User> registerParent(@RequestBody User user) {
        User registeredUser = authenticationService.registerParent(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody String token) {
        try {
            String newToken = jwtService.refreshToken(token);
            return ResponseEntity.ok(new JwtResponse(newToken));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token has expired. Please log in again.");
        }
    }
}
