package ro.ubbcluj.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Cosmin on 21-Apr-17.
 */
@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String subject;

    @Column(columnDefinition = "NVARCHAR(1400)")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<TrainingDomain> domains;

    private Date addedOn;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date fromDate;
    private double duration;
//    private Date toDate;
    /**
     * can be null
     */

    @OneToMany
    private List<ExtraDetails> extraDetailsList;

    public Training() {
        extraDetailsList = new ArrayList<ExtraDetails>();
        domains = new ArrayList<TrainingDomain>();
        addedOn = new Date();
    }

    public Training(String subject, String description, List<TrainingDomain> domains, Date fromDate) {
        this.subject = subject;
        this.description = description;
        this.domains = domains;
        this.fromDate = fromDate;
//        this.toDate = toDate;
        extraDetailsList = new ArrayList<ExtraDetails>();
        addedOn = new Date();
    }

    public Training(int id, String subject, String description, List<TrainingDomain> domains, Date fromDate) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.domains = domains;
        this.fromDate = fromDate;
        extraDetailsList = new ArrayList<ExtraDetails>();
        addedOn = new Date();
    }

    public Training(int id, String subject, String description, List<ExtraDetails> extraDetailsList, List<TrainingDomain> domains, Date fromDate) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.domains = domains;
        this.fromDate = fromDate;
        this.extraDetailsList = extraDetailsList;
        addedOn = new Date();
    }

    public void addExtraDetails(ExtraDetails extraDetails) {
        extraDetailsList.add(extraDetails);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ExtraDetails> getExtraDetailsList() {
        return extraDetailsList;
    }

    public void setExtraDetailsList(List<ExtraDetails> extraDetailsList) {
        this.extraDetailsList = extraDetailsList;
    }

    public List<TrainingDomain> getDomains() {
        return domains;
    }

    public void setDomains(List<TrainingDomain> domains) {
        this.domains = domains;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
//
//    public Date getToDate() {
//        return toDate;
//    }
//
//    public void setToDate(Date toDate) {
//        this.toDate = toDate;
//    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}


