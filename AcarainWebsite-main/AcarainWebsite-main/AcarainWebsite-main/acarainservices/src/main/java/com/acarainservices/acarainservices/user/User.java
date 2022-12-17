package com.acarainservices.acarainservices.user;

import java.io.Serializable;
// import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
// import javax.persistence.ManyToMany;
// import javax.persistence.ManyToOne;
import javax.persistence.Table;
// import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user") // ini nama table
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    @NotEmpty(message = "Firstname is required")
    private String firstName;

    @Column(length = 20)
    @NotEmpty(message = "Lastname is required")
    private String lastName;

    @Column(length = 50)
    @NotEmpty(message = "Email is required")
    private String email;

    public User() {
    }

    public User(int id,
            @NotEmpty(message = "Firstname is required") String firstname, String middlename,
            @NotEmpty(message = "Lastname is required") String lastname,
            @NotEmpty(message = "Email is required") String email) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

}
