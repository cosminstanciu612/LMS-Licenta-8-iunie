package ro.ubbcluj.dao;

import ro.ubbcluj.domain.Department;
import ro.ubbcluj.domain.Training;
import ro.ubbcluj.domain.TrainingDomain;
import ro.ubbcluj.domain.User;
import ro.ubbcluj.service.UserService;

import java.util.List;

/**
 * Created by Cosmin on 16-Apr-17.
 */
public interface MockDAO {
//    Users



//    Trainings
    List<Training> getAllTrainings();

    Training getTrainingById(int id);

    void addTraining(Training training);

    void editTraining(int id, Training newVersionTraining);

    void deleteTraining(int id);

    List<Department> getAllDepartments();

    Department getDepartmentById(int id);

    List<TrainingDomain> getAllDomains();

    TrainingDomain getTrainingDomainById(int i);
}
