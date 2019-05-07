package com.project.online_shop.service;

import com.project.online_shop.domain.Users;
import com.project.online_shop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("usersService")
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users getUserById(Long id) {
        return usersRepository.getOne(id);
    }

    @Override
    public void saveUser(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void updateUser(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void deleteUser(Users users) {
        usersRepository.delete(users);
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findUsersByUsername(String username) {
        return usersRepository.findUsersByUsername(username);
    }


//    @Override
//    public Users findByUsername (String username) {
//        return usersDao.findByUsername(username);
//    }
//
//    @Override
//    public Users getUserById(Long id) {
//        return usersDao.getUserById(id);
//    }
//
//    @Override
//    public void saveUser(Users users) {
//        usersDao.saveUser(users);
//    }
//
//    @Override
//    public void deleteUser(Users users) {
//        usersDao.deleteUser(users);
//    }
//
//    @Override
//    public void updateUser(Users users) {
//        usersDao.updateUser(users);
//    }
//
//    @Override
//    public List<Users> findAll() {
//        return usersDao.findAll();
//    }
}
