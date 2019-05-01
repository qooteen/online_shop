package com.project.online_shop.service;

import com.project.online_shop.dao.UsersDAOImpl;
import com.project.online_shop.entity.Users;
import java.util.List;

public interface UsersService {
    UsersDAOImpl usersDao = new UsersDAOImpl();

    Users findUser(Long id);

    void saveUser(Users users);

    void removeUser(Users users);

    void updateUser(Users users);

    List<Users> findAllUsers();
}
