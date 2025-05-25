package com.ihsanakbay.base_spring_boot_architecture.config;

import com.ihsanakbay.base_spring_boot_architecture.enums.RoleType;
import com.ihsanakbay.base_spring_boot_architecture.model.Role;
import com.ihsanakbay.base_spring_boot_architecture.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        initRoles();
    }

    private void initRoles() {
        try {
            if (roleRepository.count() == 0) {
                logger.info("Initializing roles in the database");
                
                Role userRole = new Role(RoleType.ROLE_USER);
                Role modRole = new Role(RoleType.ROLE_MODERATOR);
                Role adminRole = new Role(RoleType.ROLE_ADMIN);

                roleRepository.save(userRole);
                roleRepository.save(modRole);
                roleRepository.save(adminRole);

                logger.info("Roles initialized successfully");
            } else {
                logger.info("Roles already exist in the database");
            }
        } catch (Exception e) {
            logger.error("Failed to initialize roles: {}", e.getMessage());
        }
    }
}
