
package com.prm.group6.services.implement;
import com.prm.group6.model.entity.Role;
import com.prm.group6.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AccountService
{
    @Autowired
    private RoleRepository roleRepository;
    public List<String> getAllRoleToAuthenticate(){
        List<Role> roles = roleRepository.findAll();
        List<String> roleNames = new ArrayList<>();
        roles.stream().forEach(
                role-> roleNames.add(role.getRoleName()));
        return roleNames;
    }
}
