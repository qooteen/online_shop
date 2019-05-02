package com.project.online_shop.service;

import com.project.online_shop.dao.RolesRepo;
import com.project.online_shop.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolesServiceImpl implements RolesService{

    private RolesRepo rolesRepo;

    @Autowired
    public void setRolesRepo(RolesRepo rolesRepo) {
        this.rolesRepo = rolesRepo;
    }

    @Override
    public Roles getRoleById(Long id) {
        return rolesRepo.getOne(id);
    }

    @Override
    public void saveRole(Roles roles) {
        rolesRepo.save(roles);
    }

    @Override
    public void updateRole(Roles roles) {
        rolesRepo.save(roles);
    }

    @Override
    public void deleteRole(Roles roles) {
        rolesRepo.delete(roles);
    }

    @Override
    public List<Roles> findAll() {
        return rolesRepo.findAll();
    }
}
