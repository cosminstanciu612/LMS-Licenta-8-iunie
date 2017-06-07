package ro.ubbcluj.util;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubbcluj.service.TrainingService;

import java.beans.PropertyEditorSupport;
import java.util.logging.Logger;

/**
 * Created by Cosmin on 24-May-17.
 */
public class TrainingDomainEditor extends PropertyEditorSupport {

    private static final Logger LOGGER = Logger.getLogger( TrainingDomainEditor.class.getName() );

    @Autowired
    private TrainingService trainingService;

    public TrainingDomainEditor() {
    }

    public TrainingDomainEditor(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    //This will be called when user HTTP Post to server a field bound to DepartmentVO
    @Override
    public void setAsText(String id) {
        LOGGER.info(id);
        this.setValue(trainingService.getTrainingDomainById(Integer.parseInt(id)));
    }

//    Failed to convert property value of type [java.lang.String] to required type [java.util.List] for property
// 'domains'; nested exception is java.lang.IllegalStateException: Cannot convert value of type [java.lang.String]
// to required type [ro.ubbcluj.domain.TrainingDomain] for property 'domains[0]': no matching editors or conversion
// strategy found
}
