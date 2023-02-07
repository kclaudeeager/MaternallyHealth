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
public class HealthAdvisor extends AuditModel {
    /**
     *
     */
    private static final int _102 = 10;


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idnumber" , nullable = false, length = 16,unique = true)
    private String idnumber;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "Age", nullable = false)
    private String age;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "phone_number", unique = true, nullable = false,length=_102)
    private String phoneNumber;
  
    @Column(name = "residance", nullable = false)
    private String residance;
    @Column(name = "hospital_id", nullable = false)
    private Long hospital_id;
     
    public HealthAdvisor() {
    }

    public HealthAdvisor(Long id, String idnumber, String email, String age, String firstName, String lastName,
            String phoneNumber, String residance, Long hospital_id) {
        this.id = id;
        this.idnumber = idnumber;
        this.email = email;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.residance = residance;
        this.hospital_id = hospital_id;
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

   

    public String getResidance() {
        return this.residance;
    }

    public void setResidance(String residance) {
        this.residance = residance;
    }

    public HealthAdvisor id(Long id) {
        setId(id);
        return this;
    }

    


    /**
     * @return Integer return the hospital_id
     */
    public Long getHospital_id() {
        return hospital_id;
    }

    /**
     * @param hospital_id the hospital_id to set
     */
    public void setHospital_id(Long hospital_id) {
        this.hospital_id = hospital_id;
    }

}
