package com.ihsanakbay.base_spring_boot_architecture.repository;

import com.ihsanakbay.base_spring_boot_architecture.enums.RoleType;
import com.ihsanakbay.base_spring_boot_architecture.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
    Boolean existsByName(RoleType name);
}
