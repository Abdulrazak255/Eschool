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
    private final PasswordEncoder passwordEncoder; // Inject the PasswordEncoder

    public String authenticate(String username, String password) {
        try {
            UserDetails userDetails = userService.loadUserByUsername(username);

            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("Invalid username or password");
            }

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtService.generateToken(userDetails);
        } catch (BadCredentialsException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Authentication failed for user: " + username, e);
        }
    }

    // Other methods...
}
