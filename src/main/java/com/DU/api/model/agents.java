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
@Table(name = "agents")
public class agents extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idnumber", unique = true, nullable = false)
    private String idnumber;

    @Column(name = "capital")
    private String capital;

    @Column(name = "ID_type", nullable = false)
    private String idtype;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private String phoneNumber;
    @Column(name = "services", nullable = true)
    private String services;

    @Column(name = "residance", nullable = false)
    private String residance;

    public agents() {
        super();
    }

    public agents(String firstName, String lastName, String phoneNumber, String idtype, String idnumber,
            String services, String residance, String capital) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.idtype = idtype;
        this.phoneNumber = phoneNumber;
        this.idnumber = idnumber;
        this.capital = capital;
        this.residance = residance;
        this.services = services;
    }

    public Long getId() {
        return id;
    }

    public String getcapital() {
        return capital;
    }

    public void setcapital(String capital) {
        this.capital = capital;
    }

    public String getservices() {
        return services;
    }

    public void setservices(String services) {
        this.services = services;
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
