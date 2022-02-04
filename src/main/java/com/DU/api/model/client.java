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
@Table(name = "clients")
public class client extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idnumber")
    private String idnumber;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "accountnumber")
    private String accountnumber;

    @Column(name = "ID_type", nullable = false)
    private String idtype;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;
    @Column(name = "occupation", unique = true, nullable = false)
    private String occupation;

    @Column(name = "residance", nullable = false)
    private String residance;

    @Column(name = "balaance", nullable = false, columnDefinition = "integer default 0")
    private Integer balance;

    public client() {
        super();
    }

    public client(String firstName, String email, String lastName, String phoneNumber, String idtype, String idnumber,
            String occupation, String residance, String accountnumber, Integer balance) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idtype = idtype;
        this.phoneNumber = phoneNumber;
        this.idnumber = idnumber;
        this.occupation = occupation;
        this.residance = residance;
        this.accountnumber = accountnumber;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getoccupation() {
        return occupation;
    }

    public void setocccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getaccountnumber() {
        return accountnumber;
    }

    public void setaccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
