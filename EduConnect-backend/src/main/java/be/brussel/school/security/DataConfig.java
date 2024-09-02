package be.brussel.school.security;

import be.brussel.school.model.User;
import be.brussel.school.model.UserRole;
import be.brussel.school.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataConfig.class);

    @Bean
    public CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Create Teacher User
            if (!userRepository.existsByUsername("teacher")) {
                User teacher = new User();
                teacher.setUsername("teacher");
                teacher.setLastName("Doe");
                teacher.setEmail("teacher@example.com");
                teacher.setPassword(passwordEncoder.encode("teacher123"));
                teacher.setRoles(new HashSet<>(Set.of(UserRole.TEACHER)));
                logger.info("Creating teacher user...");
                userRepository.save(teacher);
                logger.info("Teacher user created.");
            }

            // Create Student User
            if (!userRepository.existsByUsername("student")) {
                User student = new User();
                student.setUsername("student");
                student.setLastName("Smith");
                student.setEmail("student@example.com");
                student.setPassword(passwordEncoder.encode("student123"));
                student.setRoles(new HashSet<>(Set.of(UserRole.STUDENT)));
                logger.info("Creating student user...");
                userRepository.save(student);
                logger.info("Student user created.");
            }

            // Create Parent User
            if (!userRepository.existsByUsername("parent")) {
                User parent = new User();
                parent.setUsername("parent");
                parent.setLastName("Brown");
                parent.setEmail("parent@example.com");
                parent.setPassword(passwordEncoder.encode("parent123"));
                parent.setRoles(new HashSet<>(Set.of(UserRole.PARENT)));
                logger.info("Creating parent user...");
                userRepository.save(parent);
                logger.info("Parent user created.");
            }

            // Create Manager User
            if (!userRepository.existsByUsername("manager")) {
                User manager = new User();
                manager.setUsername("manager");
                manager.setLastName("Johnson");
                manager.setEmail("manager@example.com");
                manager.setPassword(passwordEncoder.encode("manager123"));
                manager.setRoles(new HashSet<>(Set.of(UserRole.MANAGER)));
                logger.info("Creating manager user...");
                userRepository.save(manager);
                logger.info("Manager user created.");
            }

           /* // Create Admin User
            if (!userRepository.existsByUsername("admin")) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setLastName("Admin");
                admin.setEmail("admin@example.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRoles(new HashSet<>(Set.of(UserRole.ADMIN)));
                logger.info("Creating admin user...");
                userRepository.save(admin);
                logger.info("Admin user created.");
            }*/
        };
    }
}
