package com.project.online_shop.dao;

import com.project.online_shop.domain.Users;
import java.util.List;

public interface UsersDAO {

    Users getUserById(Long id);

    void saveUser(Users users);

    void updateUser(Users users);

    void deleteUser(Users users);

    List<Users> findAll();
}
