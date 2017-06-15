package ro.ubbcluj.service;

import ro.ubbcluj.domain.Training;
import ro.ubbcluj.domain.TrainingDomain;
import ro.ubbcluj.domain.User;

import java.util.List;

/**
 * Created by Cosmin on 21-Apr-17.
 */
public interface TrainingService {
    Training getTrainingById(int id);

    void addParticipant();

    List<Training> getAllTrainings();
    List<Training> getTrainingsByTrainer(User trainer);
    List<Training> getTrainingsByParticipant(User participant);
    List<Training> getTrainingsByDomains(List<TrainingDomain> domains);

    void addTraining(Training training);
    void editTraining(Training newVersionTraining);
    void deleteTraining(Training training);

    List<TrainingDomain> getAllDomains();

    TrainingDomain getTrainingDomainById(int i);
}
