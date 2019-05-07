package com.project.online_shop.service;

import com.project.online_shop.repository.RolesRepository;
import com.project.online_shop.domain.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("rolesService")
public class RolesServiceImpl implements RolesService{


    private RolesRepository rolesRepository;

    @Autowired
    public void setRolesRepository(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public Roles getRolesByDescriptionrole(String role) {
        return rolesRepository.getRolesByDescriptionrole(role);
    }


    @Override
    public Roles getRoleById(Long id) {
        return rolesRepository.getOne(id);
    }

    @Override
    public void saveRole(Roles roles) {
        rolesRepository.save(roles);
    }

    @Override
    public void updateRole(Roles roles) {
        rolesRepository.save(roles);
    }

    @Override
    public void deleteRole(Roles roles) {
        rolesRepository.delete(roles);
    }

    @Override
    public List<Roles> findAll() {
        return rolesRepository.findAll();
    }
}
