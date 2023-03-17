package com.prm.group6.repositories;

import com.prm.group6.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRoleName(String roleName);

    Role findByRoleId(String email);
}
