package ro.ubbcluj.domain;

import javax.persistence.*;

/**
 * Created by Cosmin on 20-May-17.
 */
@Entity
@Table(name = "trainingdomains")
public class TrainingDomain {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrainingDomain(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TrainingDomain() {
    }
}
