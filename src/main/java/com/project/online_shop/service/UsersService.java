package com.project.online_shop.service;

import com.project.online_shop.dao.UsersDAOImpl;
import com.project.online_shop.domain.Orders;
import com.project.online_shop.domain.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface UsersService {
    //UsersDAOImpl usersDao = new UsersDAOImpl();

    Users getUserById(Long id);

    void saveUser(Users users);

    void updateUser(Users users);

    void deleteUser(Users users);

   // Users findByUsername (String username);

    List<Users> findAll();

    Users findByUsername(String username);

    Users findByEmail(String email);

    Users findByPhone(String phone);
}
