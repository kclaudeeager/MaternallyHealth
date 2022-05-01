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
@Table(name = "Sport")
public class Sport extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sport_name")
    private String sport_name;

    @Column(name = "length_time")
    private Double length_time;

    public Sport(Long id,String sport_name,Double length_time){
        this.id=id;
        this.length_time=length_time;
        this.sport_name=sport_name;
    }
    public Double getLength_time() {
        return length_time;
    }

    public void setLength_time(Double length_time) {
        this.length_time= length_time;
    }
    public void setSport_name(String sport_name) {
        this.sport_name=sport_name;
    }
    public String getSport_name(){
        return sport_name;
    }
        
    public Long getId() {
            return this.id;
        }

    public void setId(Long id) {
        this.id = id;
    }
   


    

}
