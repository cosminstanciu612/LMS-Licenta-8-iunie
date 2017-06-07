package ro.ubbcluj.domain;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cosmin on 16-Apr-17.
 */
@Entity
public class User {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Training> trainingsHeld;
    private List<Training> trainingsParticipated;
    private Department department;
    private boolean deleted = false;


    public User() {
        this.trainingsHeld = new ArrayList<Training>();
        this.trainingsParticipated = new ArrayList<Training>();
    }

    public User(String email, String firstName, String lastName, String phoneNumber, Department department) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    public User(int id, String email, String firstName, String lastName, String phoneNumber, List<Training> trainingsHeld, List<Training> trainingsParticipated) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.trainingsHeld = trainingsHeld;
        this.trainingsParticipated = trainingsParticipated;
    }

    public void addTrainingHeld(Training training) {
        trainingsHeld.add(training);
    }

    public void addTrainingParticipated(Training training) {
        trainingsParticipated.add(training);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Training> getTrainingsHeld() {
        return trainingsHeld;
    }

    public void setTrainingsHeld(List<Training> trainingsHeld) {
        this.trainingsHeld = trainingsHeld;
    }

    public List<Training> getTrainingsParticipated() {
        return trainingsParticipated;
    }

    public void setTrainingsParticipated(List<Training> trainingsParticipated) {
        this.trainingsParticipated = trainingsParticipated;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void edit(User newVersionUser) {
        this.setFirstName(newVersionUser.getFirstName());
        this.setLastName(newVersionUser.getLastName());
        this.setDepartment(newVersionUser.getDepartment());
        this.setPhoneNumber(newVersionUser.getPhoneNumber());
        this.setEmail(newVersionUser.getEmail());
    }
}

