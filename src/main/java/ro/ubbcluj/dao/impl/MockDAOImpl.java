package ro.ubbcluj.dao.impl;

import org.springframework.stereotype.Repository;
import ro.ubbcluj.dao.MockDAO;
import ro.ubbcluj.domain.*;

import java.util.*;

/**
 * Created by Cosmin on 16-Apr-17.
 */
@Repository
public class MockDAOImpl implements MockDAO {
    private List<User> users;
    private List<Training> trainings;
    private List<Department> departments;
    private List<TrainingDomain> domains;


    public MockDAOImpl() {

        //domains
        domains = new ArrayList<TrainingDomain>();
        TrainingDomain trainingDomain1 = new TrainingDomain(1, "AOP");
        TrainingDomain trainingDomain2 = new TrainingDomain(2, "Artificial Intelligence");
        TrainingDomain trainingDomain3 = new TrainingDomain(3, "Bio-Medical technology");

        domains.add(trainingDomain1);
        domains.add(trainingDomain2);
        domains.add(trainingDomain3);

        // </domains>

        Department d1 = new Department(1, "Java");
        Department d2 = new Department(2, "HR");
        Department d3 = new Department(3, "IT");
        Department d4 = new Department(4, ".Net");
        Department d5 = new Department(5, "Accounting");
        Department d6 = new Department(6, "Training");

        departments = new ArrayList<Department>();
        departments.add(d1);
        departments.add(d2);
        departments.add(d3);
        departments.add(d4);
        departments.add(d5);
        departments.add(d6);

//        ***initialize users
        users = new ArrayList<User>();
        User u1 = new User();
        u1.setId(1);
        u1.setFirstName("Ionel1");
        u1.setLastName("Pop1");
        u1.setEmail("ionel1@test.com");
        u1.setPhoneNumber("545401");
        u1.setDepartment(d1);

        User u2 = new User();
        u2.setId(2);
        u2.setFirstName("Ionel2");
        u2.setLastName("Pop2");
        u2.setEmail("ionel2@test.com");
        u2.setPhoneNumber("545402");
        u2.setDepartment(d1);

        users.add(u1);
        users.add(u1);
        users.add(u1);
        users.add(u1);
        users.add(u2);
        users.add(u2);
//        initialize users***

        /** initialize trainings*/
        trainings = new ArrayList<Training>();
        Training t1 = new Training();
        t1.setId(1);
        t1.setSubject("Java Training");
        t1.setDescription("This is the description of the Java Training");
        Date fromDate = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DAY_OF_MONTH, 23);
        calendar.set(Calendar.HOUR, 16);
        calendar.set(Calendar.MINUTE, 0);
        fromDate = calendar.getTime();
        calendar.set(Calendar.HOUR, 18);
        Date toDate = calendar.getTime();
        t1.setFromDate(fromDate);
//        t1.setToDate(toDate);
        ExtraDetails extraDetails = new ExtraDetails();
        extraDetails.setId(1);
        extraDetails.setHeader("Header 1");
        extraDetails.setInformation("Information for the first extra detail");
        t1.addExtraDetails(extraDetails);
        trainings.add(t1);

        /** add training to user(s) */
        u1.addTrainingHeld(t1);
        u1.addTrainingHeld(t1);
        u1.addTrainingHeld(t1);
//        u2.addTrainingParticipated(t1);
//        u2.addTrainingParticipated(t1);
//        u2.addTrainingParticipated(t1);
    }

    public List<User> getAllUsers() {
        return this.users;
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public User deleteUser(User user) {
        for (User u : users) {
            if (u.getId() == user.getId()) {
                u.setDeleted(true);
                return u;
            }
        }
        return null;
    }

    public void editUser(User newVersionUser) {
        for (User u : users) {
            if (u.getId() == newVersionUser.getId()) {
                u.edit(newVersionUser);
            }
        }
    }

    public void addUser(User user) {
//        TODO: remove setId method because Hibernate will take care of it
//        user.setId(getNextId());
        users.add(user);
    }

    public List<Training> getAllTrainings() {
        return trainings;
    }

    public Training getTrainingById(int id) {
        for (Training training : trainings) {
            if (training.getId() == id) {
                return training;
            }
        }
        return null;
    }

    public void addTraining(Training training) {
        training.setId(new Random().nextInt());
        trainings.add(training);
    }

    public void editTraining(int id, Training newVersionTraining) {

    }

    public void deleteTraining(int id) {

    }

    public List<Department> getAllDepartments() {
        return departments;
    }

    public Department getDepartmentById(int id) {
        for (Department d : departments) {
            if (d.getId() == id)
                return d;
        }
        return null;
    }

    public List<TrainingDomain> getAllDomains() {
        return domains;
    }

    public TrainingDomain getTrainingDomainById(int i) {
        for (TrainingDomain trainingDomain : domains) {
            if (trainingDomain.getId() == i)
                return trainingDomain;
        }
        return null;
    }


    private int getNextId() {
        int maxId = 0;
        for (User u : users) {
            if (u.getId() > maxId) {
                maxId = u.getId();
            }
        }
        return ++maxId;
    }
}
