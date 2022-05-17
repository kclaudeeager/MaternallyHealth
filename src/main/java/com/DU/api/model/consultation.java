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
@Table(name = "Consultation")
public class consultation extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Consultation_ID")
    private Long id;

    @Column(name = "ConsultationType")
    private String ConsultationType;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "consulterId", nullable = false)
    private Integer consulterId;

    @Column(name = "patient_id", nullable = false)
    private Integer patientId;

    @Column(name = "hospitalId", nullable = false)
    private Long hospitalId;
    @Column(name = "patientType", nullable = false)
    private String patientType;

    public consultation() {
        super();
    }

    public consultation(Integer consulterId, String ConsultationType, String departmentId, Integer patientId,
            Long hospitalId, String patientType) {
        super();
        this.consulterId = consulterId;

        this.ConsultationType = ConsultationType;
        this.description = description;
        this.patientId = patientId;
        this.hospitalId = hospitalId;
        this.patientType = patientType;

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
     * @return String return the ConsultationType
     */
    public String getConsultationType() {
        return ConsultationType;
    }

    /**
     * @param ConsultationType the ConsultationType to set
     */
    public void setConsultationType(String ConsultationType) {
        this.ConsultationType = ConsultationType;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Integer return the staffId
     */
    public Integer getConsulterId() {
        return consulterId;
    }

    /**
     * @param staffId the staffId to set
     */
    public void setConsulterId(Integer consulterId) {
        this.consulterId = consulterId;
    }

    /**
     * @return Integer return the patientId
     */
    public Integer getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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

    /**
     * @return String return the patientType
     */
    public String getPatientType() {
        return patientType;
    }

    /**
     * @param patientType the patientType to set
     */
    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

}
