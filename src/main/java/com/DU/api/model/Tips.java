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
@Table(name = "HealthTip")
public class Tips extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tip_id")
    private Long id;

    @Column(name = "tip_name", nullable = false)
    private String tip_name;

    @Column(name = "title" , nullable = false, unique = true)
    private String title;

    @Column(name = "description", nullable = false)
    private String  description;

    @Column(name = "createdBy", nullable = false)
    private Integer createdBy;

    public Tips() {
        super();
    }

  public Tips(Long id,String tip_name,String tip_description,Integer createdBy,String title) {
    this.title = title;
    this.id = id;
    this.tip_name = tip_name;
    this.description = tip_description;
    this.createdBy = createdBy;
  }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  

    /**
     * @return String return the tip_name
     */
    public String getTip_name() {
        return tip_name;
    }

    /**
     * @param tip_name the tip_name to set
     */
    public void setTip_name(String tip_name) {
        this.tip_name = tip_name;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return Integer return the createdBy
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

}
