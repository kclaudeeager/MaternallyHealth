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
    @Column(name = "createdBy")
    private Long createdBy;
    @Column(name = "motherId")
    private Long motherId;
    
    public DOctorAdvise() {
    }

    public DOctorAdvise(Long adviceId, String advise,Long motherId,Long createdBy) {
        this.adviceId = adviceId;
        this.advise = advise;
        this.motherId = motherId;
        this.createdBy = createdBy;
    }

    public Long getAdviceId() {
        return this.adviceId;
    }

    public void setAdviceId(Long adviceId) {
        this.adviceId = adviceId;
    }

    public String getAdvise() {
        return this.advise;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }

    public DOctorAdvise adviceId(Long adviceId) {
        setAdviceId(adviceId);
        return this;
    }

   

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DOctorAdvise)) {
            return false;
        }
        DOctorAdvise dOctorAdvise = (DOctorAdvise) o;
        return Objects.equals(adviceId, dOctorAdvise.adviceId) && Objects.equals(advise, dOctorAdvise.advise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adviceId, advise);
    }

    @Override
    public String toString() {
        return "{" +
            " adviceId='" + getAdviceId() + "'" +
            ", advise='" + getAdvise() + "'" +
            "}";
    }

    /**
     * @return Long return the createdBy
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
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

}


