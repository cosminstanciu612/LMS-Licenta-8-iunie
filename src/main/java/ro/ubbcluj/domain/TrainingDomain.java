package ro.ubbcluj.domain;

/**
 * Created by Cosmin on 20-May-17.
 */
public class TrainingDomain {
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
}
