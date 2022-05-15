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
@Table(name = "DOctorAdvise")
public class  DOctorAdvise extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adviceId")
    private Long adviceId;
    
    @Column(name = "advise")
    private String advise;
    @Column(name = "createdBy", nullable = false)
    private String createdBy;
    @Column(name = "motherId")
    private Long motherId;
    @Column(name = "hospitalId")
    private Long hospitalId;
    
    public DOctorAdvise() {
    }

    public DOctorAdvise(Long adviceId, String advise,Long motherId,String createdBy,Long hospitalId) {
        this.adviceId = adviceId;
        this.advise = advise;
        this.motherId = motherId;
        this.createdBy = createdBy;
        this.hospitalId=hospitalId;
    }


  



    /**
     * @return Long return the adviceId
     */
    public Long getAdviceId() {
        return adviceId;
    }

    /**
     * @param adviceId the adviceId to set
     */
    public void setAdviceId(Long adviceId) {
        this.adviceId = adviceId;
    }

    /**
     * @return String return the advise
     */
    public String getAdvise() {
        return advise;
    }

    /**
     * @param advise the advise to set
     */
    public void setAdvise(String advise) {
        this.advise = advise;
    }

    /**
     * @return String return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return String return the motherId
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


