package ro.ubbcluj.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubbcluj.dao.UserDAO;
import ro.ubbcluj.domain.Department;
import ro.ubbcluj.domain.Training;
import ro.ubbcluj.domain.User;
import ro.ubbcluj.service.UserService;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cosmin on 16-Apr-17.
 */
@Service
public class UserServiceImpl implements UserService {

    public static String infoMessage = "";

    @Autowired
    private UserDAO userDAO;

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
//        for (User user : allUsers) {
//            if (user.getTrainingsParticipated().contains(training)) {
//                userCount++;
//            }
//        } todo: re-implement this method
        return userCount;
    }

    public void addUser(User user) {
        user.setPassword(getRandomPassword());
        userDAO.addUser(user);
    }

    public void editUser(User newVersionUser) {
        userDAO.editUser(newVersionUser);
    }

    public User deleteUser(String id) {
        return userDAO.deleteUser(Integer.parseInt(id));
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

    public List<User> searchUsers(String searchTerm, String departmentId) {
        List<User> users;
        int id = 0;
        try {
            id = Integer.parseInt(departmentId);
        }
        catch (NumberFormatException e) {
            id = 0;
        } finally {
            if (id < 0)
                id = 0;
        }


            users = userDAO.searchUsers(searchTerm, id);
        return users;
    }

    @Override
    public List<User> getAllTrainers() {
        return userDAO.getAllTrainers();
    }

    private String getRandomPassword() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }
}
