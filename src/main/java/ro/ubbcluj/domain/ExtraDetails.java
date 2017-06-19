package ro.ubbcluj.domain;

import javax.persistence.*;

/**
 * Created by Cosmin on 21-Apr-17.
 */

@Entity
@Table(name = "extradetails")
public class ExtraDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String header;

    @Column(length = 1200)
    private String information;

    public ExtraDetails() {
    }

    public ExtraDetails(int id, String header, String information) {
        this.id = id;
        this.header = header;
        this.information = information;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
