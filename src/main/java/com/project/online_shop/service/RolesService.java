package com.project.online_shop.service;

import com.project.online_shop.domain.Roles;

import java.util.List;

public interface RolesService {

    Roles getRoleById(Long id);

    void saveRole(Roles roles);

    void updateRole(Roles roles);

    void deleteRole(Roles roles);

    List<Roles> findAll();

    Roles getRolesByTitle(String title);

}
