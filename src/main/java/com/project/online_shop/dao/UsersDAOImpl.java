package com.project.online_shop.dao;

import com.project.online_shop.entity.Users;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UsersDAOImpl implements UsersDAO {
    @Override
    public void add(Users users) throws QueryException {
        Session session = getSession();
        session.save(users);
        closeTransactionSesstion();
    }

    @Override
    public List<Users> getAll() {
        openTransactionSession();

        String sql = "SELECT * FROM users";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Users.class);
        List<Users> users = query.list();

        closeTransactionSesstion();

        return users;
    }

    @Override
    public Users getById(Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM users WHERE user_id = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Users.class);
        query.setParameter("id", id);

        Users users = (Users)query.getSingleResult();

        closeTransactionSesstion();

        return users;
    }

    @Override
    public void update(Users users) {
        openTransactionSession();
        Session session = getSession();
        session.update(users);
        closeTransactionSesstion();
    }

    @Override
    public void remove(Users users) {
        openTransactionSession();
        Session session = getSession();
        session.remove(users);
        closeTransactionSesstion();
    }
}
