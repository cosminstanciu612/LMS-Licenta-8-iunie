package ro.ubbcluj.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.dao.TrainingDAO;
import ro.ubbcluj.domain.Department;
import ro.ubbcluj.domain.Training;
import ro.ubbcluj.domain.TrainingDomain;
import ro.ubbcluj.domain.User;

import java.util.List;

/**
 * Created by Cosmin on 15-Jun-17.
 */
@Repository
@Transactional
public class TrainingDAOImpl implements TrainingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Training> getAllTrainings() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Training").list();
    }

    public Training getTrainingById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Training) session.get(Training.class, id);
    }

    public void addTraining(Training training) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(training);
    }

    public void editTraining(Training newVersionTraining) {
        Session session = sessionFactory.getCurrentSession();
        session.update(newVersionTraining);
    }

    public Training deleteTraining(int id) {
        Session session = sessionFactory.getCurrentSession();
        Training training = getTrainingById(id);
        session.delete(training);
        return training;
    }

    public List<TrainingDomain> getAllDomains() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from TrainingDomain").list();
    }

    public TrainingDomain getTrainingDomainById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (TrainingDomain) session.get(TrainingDomain.class, id);
    }

    @Override
    public User getTrainerByTraining(Training training) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from User as u RIGHT OUTER JOIN u.trainingsHeld as t where t.id = :trainingId");
        query.setParameter("trainingId", training.getId());
        return (User) query.uniqueResult();
    }

    @Override
    public List<Training> getTrainingsByParticipant(User participant) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Training as t inner join t.usersJoined as u where :participant in u");
        query.setParameter("participant", participant);
        return (List<Training>) query.list();
    }
}
