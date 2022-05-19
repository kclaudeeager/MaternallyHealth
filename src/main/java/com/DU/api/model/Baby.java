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
@Table(name = "Baby")
public class Baby extends AuditModel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "motherId", nullable = false)
    private Long motherId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "height", nullable = true)
    private Double height;

    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "hosptital_id", nullable = false)
    private Long hosptital_id;

    public Baby() {
        super();
    }

    public Baby(Long id, Long motherId, String firstName, String lastName, Double weight, Double height, String status, Long hosptital_id) {
        this.id = id;
        this.motherId = motherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.status = status;
        this.hosptital_id = hosptital_id;
    }

    


    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Long return the motherId
     */
    public Long getMotherId() {
        return motherId;
    }

    /**
     * @param motherId the motherId to set
     */
    public void setMotherId(Long motherId) {
        this.motherId = motherId;
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Long return the hosptital_id
     */
    public Long getHosptital_id() {
        return hosptital_id;
    }

    /**
     * @param hosptital_id the hosptital_id to set
     */
    public void setHosptital_id(Long hosptital_id) {
        this.hosptital_id = hosptital_id;
    }

}
