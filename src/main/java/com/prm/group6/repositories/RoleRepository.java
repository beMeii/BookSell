package com.prm.group6.repositories;

import com.prm.group6.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRoleName(String roleName);
}
