package com.project.online_shop.service;

import com.project.online_shop.dao.UsersDAOImpl;
import com.project.online_shop.domain.Users;
import java.util.List;

public interface UsersService {
    //UsersDAOImpl usersDao = new UsersDAOImpl();

    Users getUserById(Long id);

    void saveUser(Users users);

    void updateUser(Users users);

    void deleteUser(Users users);

   // Users findByUsername (String username);

    List<Users> findAll();

    Users findByUsername(String username);

}
