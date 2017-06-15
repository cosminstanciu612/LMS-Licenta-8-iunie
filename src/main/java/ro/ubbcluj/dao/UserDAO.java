package ro.ubbcluj.dao;

import ro.ubbcluj.domain.Department;
import ro.ubbcluj.domain.User;

import java.util.List;

/**
 * Created by Cosmin on 16-Apr-17.
 */
public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(int id);

    User deleteUser(int id);

    void editUser(User newVersionUser);

    void addUser(User user);

    List<Department> getAllDepartments();

    Department getDepartmentById(int id);
}
