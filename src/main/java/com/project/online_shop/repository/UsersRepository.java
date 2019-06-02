package com.project.online_shop.repository;

import com.project.online_shop.domain.Orders;
import com.project.online_shop.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
}
