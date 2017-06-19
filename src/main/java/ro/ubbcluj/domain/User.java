package ro.ubbcluj.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Cosmin on 16-Apr-17.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToMany
    private List<Training> trainingsHeld;
    @OneToMany
    private List<Training> trainingsParticipated;

    @ManyToOne
    private Department department;
    private boolean deleted = false;
    private String password;

    @OneToMany
    private List<Feedback> feedbacks;


    @ManyToMany
    private List<UserRole> role = new ArrayList<>(0);

    public User() {
        this.trainingsHeld = new ArrayList<Training>();
        this.trainingsParticipated = new ArrayList<Training>();
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void edit(User newVersionUser) {
        this.setFirstName(newVersionUser.getFirstName());
        this.setLastName(newVersionUser.getLastName());
        this.setDepartment(newVersionUser.getDepartment());
        this.setPhoneNumber(newVersionUser.getPhoneNumber());
        this.setEmail(newVersionUser.getEmail());
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<UserRole> getRole() {
        return role;
    }

    public void setRole(List<UserRole> role) {
        this.role = role;
    }
}

