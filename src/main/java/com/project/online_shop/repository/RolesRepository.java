package com.project.online_shop.repository;

import com.project.online_shop.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("rolesRepository")
public interface RolesRepository extends JpaRepository<Roles, Long> {

    Roles getRolesByDescriptionrole(String role);
}
