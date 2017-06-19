package ro.ubbcluj.domain;

import javax.persistence.*;

@Entity
@Table(name = "userroles")
public class UserRole {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role")
    private String role;

    public UserRole() {
    }

    public UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
