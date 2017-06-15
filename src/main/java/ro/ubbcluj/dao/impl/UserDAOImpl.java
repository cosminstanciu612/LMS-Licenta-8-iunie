package ro.ubbcluj.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.dao.UserDAO;
import ro.ubbcluj.domain.TrainingDomain;
import ro.ubbcluj.domain.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Cosmin on 14-Jun-17.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getAllUsers() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<User> users = (List<User>) session.createQuery("from User").list();
        session.close();
        return users;
    }

    public User getUserById(int id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        User user = (User) session.get(User.class, id);
        session.close();
        return user;
    }

    public User deleteUser(int id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        User user = (User) session.get(User.class, id);
        user.setDeleted(true);
        user.setPhoneNumber("0099888");
        session.update(user);
        session.close();
        return user;
    }

    public void editUser(User newVersionUser) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.update(newVersionUser);
        session.close();
    }

    public void addUser(User user) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.persist(user);
        session.close();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
