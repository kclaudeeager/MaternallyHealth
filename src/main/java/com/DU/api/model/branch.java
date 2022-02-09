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
@Table(name = "branch")
public class branch extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_ID")
    private Long id;

    @Column(name = "branchname")
    private String branchname;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "openingHour", nullable = true)
    private String openingHour;

    @Column(name = "closinghours", unique = false, nullable = false)
    private String closingHour;
    @Column(name = "staffNumber", unique = false, nullable = false)
    private String staffNumber;
    @Column(name = "phoneNumber", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "branchManager", nullable = false)
    private String branchManager;

    public branch() {
        super();
    }

    public branch(String address, String openingHour, String closingHour, String branchname,
            String staffNumber, String branchManager, String phoneNumber) {
        super();
        this.address = address;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.branchname = branchname;
        this.staffNumber = staffNumber;
        this.branchManager = branchManager;
        this.phoneNumber = phoneNumber;

    }

    public branch(String openingHour, String closingHour, String branchname,
            String phoneNumber) {
        super();

        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.branchname = branchname;
        this.phoneNumber = phoneNumber;

    }

    public Long getId() {
        return id;
    }

    public void setstaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getstaffNumber() {
        return staffNumber;
    }

    public void setbranchManager(String branchManager) {
        this.branchManager = branchManager;
    }

    public String getbranchManager() {
        return branchManager;
    }

    public String getbranchname() {
        return branchname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getopeningHour() {
        return openingHour;
    }

    public void setopeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    public String getclosingHour() {
        return closingHour;
    }

    public void setclosingHour(String closingHour) {
        this.closingHour = closingHour;
    }

    public void setphoneNumber(String phonenumber) {
        this.phoneNumber = phonenumber;
    }

    public String getphoneNumbe() {
        return phoneNumber;
    }

}
