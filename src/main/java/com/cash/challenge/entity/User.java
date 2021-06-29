package com.cash.challenge.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "email is mandatory")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "lastName is mandatory")
    @Column(name = "firstName")
    private String firstName;

    @NotBlank(message = "lastName is mandatory")
    @Column(name = "lastName")
    private String lastName;

    @OneToMany(mappedBy="user", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Loan> loans;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString(){
        return "User[id:"+(id==null?"null":id.toString())+
                "firstName:"+firstName +
                "lastName" +lastName +
                "email" + email +"]";
    }

}
