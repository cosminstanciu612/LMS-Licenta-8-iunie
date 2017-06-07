package ro.ubbcluj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubbcluj.dao.MockDAO;
import ro.ubbcluj.domain.Department;
import ro.ubbcluj.domain.Training;
import ro.ubbcluj.domain.User;
import ro.ubbcluj.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cosmin on 16-Apr-17.
 */
@Service
public class UserServiceImpl implements UserService {

    public static String infoMessage = "";

    @Autowired
    private MockDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public List<Department> getAllDepartments() {
        return userDAO.getAllDepartments();
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    public List<User> getUsersByDepartment(Department department) {
        List<User> allUsers = getAllUsers();
        List<User> result = new ArrayList<User>();
        for (User user : allUsers) {
            if (user.getDepartment().equals(department)) {
                result.add(user);
            }
        }
        return result;
    }

    public int getUsersCountForTraining(Training training) {
        List<User> allUsers = getAllUsers();
        int userCount = 0;
        for (User user : allUsers) {
            if (user.getTrainingsParticipated().contains(training)) {
                userCount++;
            }
        }
        return userCount;
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public void editUser(User newVersionUser) {
        userDAO.editUser(newVersionUser);
    }

    public User deleteUser(String id) {
        return userDAO.deleteUser(getUserById(Integer.parseInt(id)));
    }

    public Department getDepartmentById(int i) {
        return userDAO.getDepartmentById(i);
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }
}
