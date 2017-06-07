package ro.ubbcluj.domain;

/**
 * Created by Cosmin on 21-Apr-17.
 */
public class ExtraDetails {
    private int id;
    private String header;
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
