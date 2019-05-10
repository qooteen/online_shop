package com.project.online_shop.repository;

import com.project.online_shop.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
}
