package ro.ubbcluj.domain;

import javax.persistence.*;

/**
 * Created by Cosmin on 14-Jun-17.
 */
@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double rating;
    private String message;

    public Feedback() {
    }

    public Feedback(double rating, String message) {
        this.rating = rating;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
