package ro.ubbcluj.domain;

import javax.persistence.Entity;

/**
 * Created by Cosmin on 23-Apr-17.
 */
@Entity
public class Department {
    private int id;
    private String name;

    public Department() {
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object ot) {
        boolean result = false;

        if (ot != null && this != null && ot instanceof Department) {
            result = this.getId() == ((Department) ot).getId();
        }
        return result;
    }
//
//    @Override
//    public String toString() {
//        return this.getName();
//    }
}
