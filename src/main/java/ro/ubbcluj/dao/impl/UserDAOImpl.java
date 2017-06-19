package ro.ubbcluj.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.dao.UserDAO;
import ro.ubbcluj.domain.Department;
import ro.ubbcluj.domain.User;

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

    public List<User> searchUsers(String searchTerm, int departmentId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = getQuery(searchTerm, departmentId);
        Query query = session.createQuery(hql);
        if (StringUtils.isNotEmpty(searchTerm))
            query.setParameter("searchField", searchTerm);
        if (departmentId > 0)
            query.setParameter("department", getDepartmentById(departmentId));
        return (List<User>) query.list();

    }

    @Override
    public User getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User as u where u.email = :email");
        query.setParameter("email", email);
        return (User) query.uniqueResult();
    }

    private String getQuery(String searchTerm, int departmentId) {
        String hql = "from User as u ";
        if (StringUtils.isNotEmpty(searchTerm) || departmentId > 0) {
            hql += "where ";
            if (StringUtils.isNotEmpty(searchTerm)) {
                hql += "(u.firstName like :searchField " +
                        "or u.lastName like :searchField)";
                if (departmentId > 0) {
                    hql += " AND u.department = :department";
                }
            } else {
                hql += " u.department = :department";
            }
        }
        return hql;
    }

}
