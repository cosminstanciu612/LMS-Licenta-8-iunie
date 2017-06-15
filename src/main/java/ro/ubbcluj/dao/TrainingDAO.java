package ro.ubbcluj.dao;

import ro.ubbcluj.domain.Department;
import ro.ubbcluj.domain.Training;
import ro.ubbcluj.domain.TrainingDomain;

import java.util.List;

/**
 * Created by Cosmin on 15-Jun-17.
 */
public interface TrainingDAO {
    List<Training> getAllTrainings();

    Training getTrainingById(int id);

    void addTraining(Training training);

    void editTraining(Training newVersionTraining);

    Training deleteTraining(int id);

    List<TrainingDomain> getAllDomains();

    TrainingDomain getTrainingDomainById(int id);
}
