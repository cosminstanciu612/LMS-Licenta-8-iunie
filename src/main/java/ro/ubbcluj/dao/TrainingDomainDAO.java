package ro.ubbcluj.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.domain.TrainingDomain;

import java.util.List;

/**
 * Created by Cosmin on 14-Jun-17.
 */
@Repository
@Transactional
public interface TrainingDomainDAO {

    List<TrainingDomain> getTrainingDomains();
}
