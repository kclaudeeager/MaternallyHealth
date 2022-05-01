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
@Table(name = "Mother")
public class Mother extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idnumber")
    private String idnumber;

    @Column(name = "email", unique = true, nullable = true)
    private String email;

    @Column(name = "Age", nullable = false)
    private String age;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;
    @Column(name = "height", unique = true, nullable = false)
    private Double height;

    @Column(name = "residance", nullable = false)
    private String residance;

    @Column(name = "weight", nullable = false, columnDefinition = "integer default 0")
    private Double weight;
    @Column(name = "status", nullable = false, columnDefinition = "integer default 0")
    private Integer status;

    public Mother() {
        super();
    }

    public Mother(String firstName, String email, String lastName, String phoneNumber, String age, String idnumber,
        Double height, String residance, Integer status, Double weight) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.idnumber = idnumber;
        this.height = height;
        this.residance = residance;
        this.status = status;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public Double getheight() {
        return height;
    }

    public void setocccupation(Double height) {
        this.height = height;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getstatus() {
        return status;
    }

    public void setstatus(Integer status) {
        this.status = status;

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

    public String getage() {
        return age;
    }

    public void setage(String age) {
        this.age = age;
    }

    public Double getweight() {
        return weight;
    }

    public void setweight(Double weight) {
        this.weight = weight;
    }

}
