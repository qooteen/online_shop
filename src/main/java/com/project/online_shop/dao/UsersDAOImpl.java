package com.project.online_shop.dao;

import com.project.online_shop.bl.HibernateSessionFactory;
import com.project.online_shop.domain.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("usersDAOImpl")
public class UsersDAOImpl implements UsersDAO {

    @Override
    public Users findByUsername (String username) {
        return HibernateSessionFactory.getSessionFactory().openSession().find(Users.class, username);
    }


    @Override
    public Users getUserById(Long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Users.class, id);
    }

    @Override
    public List<Users> findAll() {
        List<Users> users = (List<Users>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("FROM users").list();
        return users;
    }

    @Override
    public void saveUser(Users users) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(users);

        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(Users users) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(users);

        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(Users users) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(users);

        transaction.commit();
        session.close();
    }
}
