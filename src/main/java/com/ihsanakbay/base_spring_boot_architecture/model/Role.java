package com.ihsanakbay.base_spring_boot_architecture.model;

import com.ihsanakbay.base_spring_boot_architecture.enums.RoleType;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", length = 20, unique = true, nullable = false)
    private RoleType name;

    public Role() {
    }

    public Role(RoleType name) {
        this.name = name;
    }

    public RoleType getName() {
        return name;
    }

    public void setName(RoleType name) {
        this.name = name;
    }
}
