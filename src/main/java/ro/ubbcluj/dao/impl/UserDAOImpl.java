package ro.ubbcluj.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.dao.UserDAO;
import ro.ubbcluj.domain.Department;
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
        Session session = sessionFactory.getCurrentSession();
        return (List<User>) session.createQuery("FROM User").list();
    }

    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.get(User.class, id);
    }

    public User deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        user.setDeleted(true);
        session.update(user);
        return user;
    }

    public void editUser(User newVersionUser) {
        Session session = sessionFactory.getCurrentSession();
        session.update(newVersionUser);
    }

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<Department> getAllDepartments() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Department").list();
    }

    public Department getDepartmentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Department) session.get(Department.class, id);
    }

}
