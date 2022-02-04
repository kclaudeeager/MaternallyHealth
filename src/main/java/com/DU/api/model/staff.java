package com.DU.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Entity
@Table(name = "staffs")
public class staff extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idnumber")
    private String idnumber;

    @Column(name = "workingDays")
    private String workingDays;

    @Column(name = "ID_type", nullable = false)
    private String idtype;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private String phoneNumber;
    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "residance", nullable = false)
    private String residance;

    public staff() {
        super();
    }

    public staff(String email, String firstName, String lastName, String phoneNumber, String idtype, String idnumber,
            String title, String residance, String workingDays) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idtype = idtype;
        this.phoneNumber = phoneNumber;
        this.idnumber = idnumber;
        this.title = title;
        this.residance = residance;
        this.workingDays = workingDays;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String gettitle() {
        return title;
    }

    public void setTittle(String title) {
        this.title = title;
    }

    public String getworkingDays() {
        return workingDays;
    }

    public void setworkingDays(String workingDays) {
        this.workingDays = workingDays;
    }

    public String getresidance() {
        return residance;
    }

    public void setresidance(String residance) {
        this.residance = residance;
    }

    public void setidnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getidnumber() {
        return idnumber;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getidtype() {
        return idtype;
    }

    public void setidtype(String idtype) {
        this.idtype = idtype;
    }

}
