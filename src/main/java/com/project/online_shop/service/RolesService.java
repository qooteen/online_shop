package com.project.online_shop.service;

import com.project.online_shop.entity.Roles;

import java.util.List;

public interface RolesService {

    Roles getRoleById(Long id);

    void saveRole(Roles roles);

    void updateRole(Roles roles);

    void deleteRole(Roles roles);

    List<Roles> findAll();
}
