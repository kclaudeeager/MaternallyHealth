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

    @Column(name = "idnumber", unique = true)
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
    @Column(name = "height", nullable = false)
    private Double height;

    @Column(name = "residance", nullable = false)
    private String residance;

    @Column(name = "weight", nullable = false, columnDefinition = "integer default 0")
    private Double weight;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "registerId")
    private Long registerId;
    @Column(name = "hospitalId", nullable = false)
    private Long hospitalId;
     
    public Mother() {
        super();
    }

    public Mother(String firstName, String email, String lastName, String phoneNumber, String age, String idnumber,
            Double height, String residance, String status, Double weight,Long hospitalId) {
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
        this.hospitalId= hospitalId;
       
    }

    public Long getId() {
        return id;
    }

    public Double getheight() {
        return height;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
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

    /**
     * @return String return the idnumber
     */
    public String getIdnumber() {
        return idnumber;
    }

    /**
     * @param idnumber the idnumber to set
     */
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    /**
     * @return String return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return Double return the height
     */
    public Double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * @return String return the residance
     */
    public String getResidance() {
        return residance;
    }

    /**
     * @param residance the residance to set
     */
    public void setResidance(String residance) {
        this.residance = residance;
    }

    /**
     * @return Double return the weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * @return Integer return the status
     */
    public String getStatus() {
        return status;
    }



    /**
     * @param registerId the registerId to set
     */
    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }


    /**
     * @return Long return the hospitalId
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId the hospitalId to set
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

}
