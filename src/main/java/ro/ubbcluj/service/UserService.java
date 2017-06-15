package ro.ubbcluj.service;

import ro.ubbcluj.domain.Department;
import ro.ubbcluj.domain.Training;
import ro.ubbcluj.domain.User;

import java.util.List;

/**
 * Created by Cosmin on 16-Apr-17.
 */
public interface UserService {
    List<User> getAllUsers();
    List<Department> getAllDepartments();

    User getUserById(int userEmail);

    List<User> getUsersByDepartment(Department department);
    int getUsersCountForTraining(Training training);

    void addUser(User user);
    void editUser(User newVersionUser);

    User deleteUser(String id);

    Department getDepartmentById(int i);

    String getInfoMessage();

    void setInfoMessage(String infoMessage);
}
