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

    @Column(name = "staffId", nullable = false)
    private Integer staffId;


    public consultation() {
        super();
    }

    public consultation(Integer staffId, String ConsultationType) {
        super();
        this.staffId = staffId;
       
        this.ConsultationType = ConsultationType;
    
     

    }

    public consultation(String ConsultationType) {
        super();
        this.ConsultationType = ConsultationType;

    }

    public Long getId() {
        return id;
    }

    public String getConsultationType() {
        return ConsultationType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getstaffId() {
        return staffId;
    }

    public void setstaffId(Integer staffId) {
        this.staffId = staffId;
    }

}

    

