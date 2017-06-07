package ro.ubbcluj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubbcluj.dao.MockDAO;
import ro.ubbcluj.domain.Training;
import ro.ubbcluj.domain.TrainingDomain;
import ro.ubbcluj.domain.User;
import ro.ubbcluj.service.TrainingService;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Cosmin on 21-Apr-17.
 */
@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private MockDAO trainingDAO;

    public Training getTrainingById(int id) {
        return trainingDAO.getTrainingById(id);
    }

    public void addParticipant() {

//        final String username = "trail.hybris2016@gmail.com";
//        final String password = "70x1c612.Hybris";
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("trail.hybris2016@gmail.com"));
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse("c.stanciu612@gmail.com"));
//            message.setSubject("Testing Subject");
//            message.setText("Dear Mail Crawler,"
//                    + "\n\n No spam to my email, please!");
//
//            Transport.send(message);
//
//            System.out.println("Done");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
    }

    public List<Training> getAllTrainings() {
        return trainingDAO.getAllTrainings();
    }

    public List<Training> getTrainingsByTrainer(User trainer) {
        return trainer.getTrainingsHeld();
    }

    public List<Training> getTrainingsByParticipant(User participant) {
        return participant.getTrainingsParticipated();
    }

    public List<Training> getTrainingsByDomains(List<TrainingDomain> domains) {
        List<Training> allTrainings = getAllTrainings();
        List<Training> resultTrainings = new ArrayList<Training>();
        for (Training training : allTrainings) {
            if (training.getDomains().containsAll(domains)) {
                resultTrainings.add(training);
            }
        }
        return resultTrainings;
    }

    public void addTraining(Training training) {
        trainingDAO.addTraining(training);
    }

    public void editTraining(Training oldVersionTraining, Training newVersionTraining) {
        trainingDAO.editTraining(oldVersionTraining.getId(), newVersionTraining);
    }

    public void deleteTraining(Training training) {
        trainingDAO.deleteTraining(training.getId());
    }

    public List<TrainingDomain> getAllDomains() {
        return trainingDAO.getAllDomains();
    }

    public TrainingDomain getTrainingDomainById(int i) {
        return trainingDAO.getTrainingDomainById(i);
    }
}
