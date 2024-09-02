package be.brussel.school.security;

import be.brussel.school.model.User;
import be.brussel.school.model.UserRole;
import be.brussel.school.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public String authenticate(String username, String password) {
        try {
            User user = userService.getUserByUsernameOrEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            // تحقق من تطابق كلمة المرور العادية بدلاً من استخدام passwordEncoder
            if (!password.equals(user.getPassword())) {
                throw new BadCredentialsException("Bad credentials");
            }

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), password));
            UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
            return jwtService.generateToken(userDetails);
        } catch (Exception e) {
            throw new RuntimeException("Authentication failed for user: " + username, e);
        }
    }

    public User registerTeacher(User user) {
        return registerUserWithRole(user, UserRole.TEACHER);
    }

    public User registerManager(User user) {
        return registerUserWithRole(user, UserRole.MANAGER);
    }

    public User registerStudent(User user) {
        return registerUserWithRole(user, UserRole.STUDENT);
    }

    public User registerParent(User user) {
        return registerUserWithRole(user, UserRole.PARENT);
    }

    private User registerUserWithRole(User user, UserRole role) {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        // قم بإزالة سطر تشفير كلمة المرور
        // user.setPassword(passwordEncoder.encode(user.getPassword()));

        // تأكد من تعيين الأدوار بشكل صحيح
        Set<UserRole> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return userService.saveUser(user);
    }
}
