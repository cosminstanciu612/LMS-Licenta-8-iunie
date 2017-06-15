package ro.ubbcluj.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.dao.TrainingDomainDAO;
import ro.ubbcluj.domain.TrainingDomain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Cosmin on 14-Jun-17.
 */
@Repository
@Transactional
public class TrainingDomainDAOImpl implements TrainingDomainDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<TrainingDomain> getTrainingDomains() {
        return (List<TrainingDomain>) sessionFactory.openSession().createQuery("from TrainingDomain").list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
