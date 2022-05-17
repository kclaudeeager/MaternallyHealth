package com.DU.api.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.Hidden;

@Entity
@Table(name = "RendezVous")
public class Rendez_vous extends AuditModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "mother_id", nullable = false)
    private Long mother_id;

    @Column(name = "hospitalId", nullable = false)
    private Long hospitalId;
    @Column(name = "stuff_id", nullable = false)
    private Long stuff_id;
    @Column(name = "feedback", nullable = false)
    private String feedback;
    @Column(name = "description")
    private String description;

    @Column(name = "atWhen", nullable = false)
    private Date atWhen;

    public Rendez_vous() {

    }

    public Rendez_vous(Long id, Long mother_id, Long stuff_id, Long hospitalId, String feedback, String description,
            Date atWhen) {
        this.id = id;
        this.mother_id = mother_id;
        this.stuff_id = stuff_id;
        this.hospitalId = hospitalId;
        this.feedback = feedback;
        this.description = description;
        this.atWhen = atWhen;
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
     * @return Long return the mother_id
     */
    public Long getMother_id() {
        return mother_id;
    }

    /**
     * @param mother_id the mother_id to set
     */
    public void setMother_id(Long mother_id) {
        this.mother_id = mother_id;
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
     * @return Long return the stuff_id
     */
    public Long getStuff_id() {
        return stuff_id;
    }

    /**
     * @param stuff_id the stuff_id to set
     */
    public void setStuff_id(Long stuff_id) {
        this.stuff_id = stuff_id;
    }

    /**
     * @return String return the feedback
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
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
     * @return Date return the atWhen
     */
    public Date getAtWhen() {
        return atWhen;
    }

    /**
     * @param atWhen the atWhen to set
     */
    public void setAtWhen(Date atWhen) {
        this.atWhen = atWhen;
    }

}