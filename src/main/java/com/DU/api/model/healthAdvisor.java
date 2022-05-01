package com.DU.api.model;
import java.util.Objects;

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
@Table(name = "healthAdvisor")
public class healthAdvisor 
extends AuditModel {

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

    public healthAdvisor() {
    }

    public healthAdvisor(Long id, String idnumber, String email, String age, String firstName, String lastName, String phoneNumber, Double height, String residance) {
        this.id = id;
        this.idnumber = idnumber;
        this.email = email;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.height = height;
        this.residance = residance;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdnumber() {
        return this.idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getResidance() {
        return this.residance;
    }

    public void setResidance(String residance) {
        this.residance = residance;
    }

    public healthAdvisor id(Long id) {
        setId(id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof healthAdvisor)) {
            return false;
        }
        healthAdvisor healthAdvisor = (healthAdvisor) o;
        return Objects.equals(id, healthAdvisor.id) && Objects.equals(idnumber, healthAdvisor.idnumber) && Objects.equals(email, healthAdvisor.email) && Objects.equals(age, healthAdvisor.age) && Objects.equals(firstName, healthAdvisor.firstName) && Objects.equals(lastName, healthAdvisor.lastName) && Objects.equals(phoneNumber, healthAdvisor.phoneNumber) && Objects.equals(height, healthAdvisor.height) && Objects.equals(residance, healthAdvisor.residance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idnumber, email, age, firstName, lastName, phoneNumber, height, residance);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", idnumber='" + getIdnumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", age='" + getAge() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", height='" + getHeight() + "'" +
            ", residance='" + getResidance() + "'" +
            "}";
    }

}

