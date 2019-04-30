package com.project.online_shop.dao;

import com.project.online_shop.entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {
    void add(Users users) throws SQLException;

    List<Users> getAll() throws SQLException;

    Users getById(Long id) throws SQLException;

    void update(Users users) throws SQLException;

    void remove(Users users) throws SQLException;
}
