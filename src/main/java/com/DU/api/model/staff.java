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

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phoneNumber", nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "DepartmentId", nullable = false)
    private Long departmentId;
 
    public staff() {
        super();
    }

    public staff(String email, String firstName, String lastName, String phoneNumber, String idtype, String idnumber,
            String title, Long departmentId, String workingDays) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.departmentId = departmentId;
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

    

    public Long getdepartmentId() {
        return departmentId;
    }

    public void setdepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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

}
