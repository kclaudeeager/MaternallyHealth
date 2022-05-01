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
@Entity
@Table(name = "RendezVous")
public class Rendez_vous extends AuditModel {
      private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "mother_id")
    private Integer mother_id;

    @Column(name = "stuff_id")
    private Integer stuff_id;

    public Rendez_vous(Long id,Integer mother_id,Integer stuff_id){
        this.id=id;
        this.mother_id=mother_id;
        this.stuff_id=stuff_id;
    }
    public Integer getMother_id() {
        return mother_id;
    }

    public void setMother_id(Integer mother_id) {
        this.mother_id=mother_id;
    }
    public void setStuff_id(Integer stuff_id) {
        this.stuff_id=stuff_id;
    }
    public Integer getStuff_id(){
        return stuff_id;
    }
        
    public Long getId() {
            return this.id;
        }

    public void setId(Long id) {
        this.id = id;
    }
   


}
