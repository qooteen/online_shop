package com.project.online_shop.dao;

import com.project.online_shop.entity.Users;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface UsersDAO {

    Users findById(Long id) throws SQLException;

    void save(Users users) throws SQLException;

    void update(Users users) throws SQLException;

    void remove(Users users) throws SQLException;

    List<Users> findAll() throws SQLException;
}
