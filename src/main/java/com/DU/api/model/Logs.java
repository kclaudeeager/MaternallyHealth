package com.DU.api.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@Entity
@Table(name = "Logs")
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, unique = false, length = 45)
    @Email(message = "Email should be valid")
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Time", nullable = false, updatable = false)
    private Date time;

    @Column(name = "Activity", nullable = false, unique = false, length = 100)
    private String activity;

    public Logs() {

    }

    public Logs(Date time, String email, String activity) {
        super();
        this.time = time;
        this.email = email;
        this.activity = activity;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date gettime() {
        return time;
    }

    public void settime(Date time) {
        this.time = time;
    }

}