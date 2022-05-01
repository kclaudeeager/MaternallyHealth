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



    @Column(name = "MotherID", nullable = false)
    private Integer motherId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
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

    public Baby(Long id, Integer motherId, String firstName, String lastName, Double weight, Double height, String status, Long hosptital_id) {
        this.id = id;
        this.motherId = motherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.status = status;
        this.hosptital_id = hosptital_id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMotherId() {
        return this.motherId;
    }

    public void setMotherId(Integer motherId) {
        this.motherId = motherId;
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

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getHosptital_id() {
        return this.hosptital_id;
    }

    public void setHosptital_id(Long hosptital_id) {
        this.hosptital_id = hosptital_id;
    }

    public Baby id(Long id) {
        setId(id);
        return this;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Baby)) {
            return false;
        }
        Baby baby = (Baby) o;
        return Objects.equals(id, baby.id) && Objects.equals(motherId, baby.motherId) && Objects.equals(firstName, baby.firstName) && Objects.equals(lastName, baby.lastName) && Objects.equals(weight, baby.weight) && Objects.equals(height, baby.height) && Objects.equals(status, baby.status) && Objects.equals(hosptital_id, baby.hosptital_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, motherId, firstName, lastName, weight, height, status, hosptital_id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", motherId='" + getMotherId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", weight='" + getWeight() + "'" +
            ", height='" + getHeight() + "'" +
            ", status='" + getStatus() + "'" +
            ", hosptital_id='" + getHosptital_id() + "'" +
            "}";
    }

    

}
