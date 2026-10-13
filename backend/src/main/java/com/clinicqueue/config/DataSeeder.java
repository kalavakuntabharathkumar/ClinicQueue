package com.clinicqueue.config;

import com.clinicqueue.model.AppUser;
import com.clinicqueue.model.Role;
import com.clinicqueue.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {
    @Bean CommandLineRunner seedDemoAccounts(UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (users.findByEmail("admin@clinicqueue.local").isEmpty()) {
                users.save(new AppUser("Clinic Admin", "admin@clinicqueue.local", encoder.encode("AdminPass123!"), Role.ADMIN));
            }
            if (users.findByEmail("doctor@clinicqueue.local").isEmpty()) {
                users.save(new AppUser("Dr. Demo", "doctor@clinicqueue.local", encoder.encode("DoctorPass123!"), Role.DOCTOR));
            }
        };
    }
}
