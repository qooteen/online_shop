package com.project.online_shop.service;

import com.project.online_shop.domain.Users;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("usersService")
public class UsersServiceImpl implements UsersService{

    @Override
    public Users getUserById(Long id) {
        return usersDao.getUserById(id);
    }

    @Override
    public void saveUser(Users users) {
        usersDao.saveUser(users);
    }

    @Override
    public void deleteUser(Users users) {
        usersDao.deleteUser(users);
    }

    @Override
    public void updateUser(Users users) {
        usersDao.updateUser(users);
    }

    @Override
    public List<Users> findAll() {
        return usersDao.findAll();
    }
}
