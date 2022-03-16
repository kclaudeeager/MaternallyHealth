package com.DU.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
    @Entity
    @Table(name = "plate")
public class Plate extends AuditModel{
    
    private static final long serialVersionUID = 1L;
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(name = "platenumber")
        private String platenumber;
public Plate()
{
    super();
}
public Plate(String platenumber){
    super();
    this.platenumber=platenumber;
}
public String getplatenumber() {
    return platenumber;
}

public void setPlatenumber(String platenumber) {
    this.platenumber=platenumber;
}


}
