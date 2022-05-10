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
@Table(name = "Hospital")
public class Hospital extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Hospital_ID")
    private Long id;

    @Column(name = "hospitalname")
    private String hospitalname;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "phoneNumber", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "hospitalAdmin", nullable = false)
    private String hospitalAdmin;

    public Hospital() {
        super();
    }

    public Hospital(String location, String hospitalname,
            String staffNumber, String hospitalAdmin, String phoneNumber) {
        super();
        this.location = location;

        this.hospitalname = hospitalname;

        this.hospitalAdmin = hospitalAdmin;
        this.phoneNumber = phoneNumber;

    }

    public Hospital(String openingHour, String closingHour, String hospitalname,
            String phoneNumber) {
        super();
        this.hospitalname = hospitalname;
        this.phoneNumber = phoneNumber;

    }

    public Long getId() {
        return id;
    }

    public void sethospitalAdmin(String hospitalAdmin) {
        this.hospitalAdmin = hospitalAdmin;
    }

    public String gethospitalAdmin() {
        return hospitalAdmin;
    }

    public String gethospitalname() {
        return hospitalname;
    }

    public void sethospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public void setphoneNumber(String phonenumber) {
        this.phoneNumber = phonenumber;
    }

    public String getphoneNumbe() {
        return phoneNumber;
    }

}
