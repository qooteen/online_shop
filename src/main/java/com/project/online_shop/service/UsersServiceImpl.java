package com.project.online_shop.service;

import com.project.online_shop.domain.Orders;
import com.project.online_shop.domain.Roles;
import com.project.online_shop.domain.Users;
import com.project.online_shop.repository.RolesRepository;
import com.project.online_shop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("usersService")
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    private RolesRepository rolesRepository;

    @Autowired
    public void setRolesRepository(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Autowired
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

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

        users.setPassword(passwordEncoder().encode(users.getPassword()));
        Set<Roles> roles = new HashSet<>();
        roles.add(rolesRepository.getRolesByTitle("ROLE_USER"));
        users.setRoles(roles);
        users.setActive(true);
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
    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Users findByPhone(String phone) {
        return usersRepository.findByPhone(phone);
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
