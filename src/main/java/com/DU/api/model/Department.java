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
@Table(name = "departments")
public class Department extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "department_name", nullable = false)
    private String department_name;

    @Column(name = "hospital_id", nullable = false)
    private Long hospital_id;
    
    public Department(String department_name, Long hospital_id) {
      this.department_name =department_name;
      this.hospital_id =hospital_id;
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
     * @return String return the department_name
     */
    public String getDepartment_name() {
        return department_name;
    }

    /**
     * @param department_name the department_name to set
     */
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    /**
     * @return Long return the hospital_id
     */
    public Long getHospital_id() {
        return hospital_id;
    }

    /**
     * @param hospital_id the hospital_id to set
     */
    public void setHospital_id(Long hospital_id) {
        this.hospital_id = hospital_id;
    }

}
