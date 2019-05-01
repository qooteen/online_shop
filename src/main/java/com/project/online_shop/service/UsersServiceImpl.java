package com.project.online_shop.service;

import com.project.online_shop.entity.Users;
import java.util.List;

public class UsersServiceImpl implements UsersService{

    @Override
    public Users findUser(Long id) {
        return usersDao.findById(id);
    }

    @Override
    public void saveUser(Users users) {
        usersDao.save(users);
    }

    @Override
    public void removeUser(Users users) {
        usersDao.remove(users);
    }

    @Override
    public void updateUser(Users users) {
        usersDao.update(users);
    }

    @Override
    public List<Users> findAllUsers() {
        return usersDao.findAll();
    }
}
