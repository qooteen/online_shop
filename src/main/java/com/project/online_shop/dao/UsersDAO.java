package com.project.online_shop.dao;

import com.project.online_shop.entity.Users;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsersDAO {

    Users getUserById(Long id);

    void saveUser(Users users);

    void updateUser(Users users);

    void deleteUser(Users users);

    List<Users> findAll();
}
