

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
@Table(name = "Food")
public class  Food extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long food_id;
    
    @Column(name = "food_name")
    private String food_name;

    @Column(name = "food_group")
    private String food_grroup;
    public Food() {
    }

    public Food(Long food_id, String food_name, String food_grroup) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_grroup = food_grroup;
    }

    public Long getFood_id() {
        return this.food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return this.food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_grroup() {
        return this.food_grroup;
    }

    public void setFood_grroup(String food_grroup) {
        this.food_grroup = food_grroup;
    }

    public Food food_id(Long food_id) {
        setFood_id(food_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Food)) {
            return false;
        }
        Food food = (Food) o;
        return Objects.equals(food_id, food.food_id) && Objects.equals(food_name, food.food_name) && Objects.equals(food_grroup, food.food_grroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food_id, food_name, food_grroup);
    }

    @Override
    public String toString() {
        return "{" +
            " food_id='" + getFood_id() + "'" +
            ", food_name='" + getFood_name() + "'" +
            ", food_grroup='" + getFood_grroup() + "'" +
            "}";
    }


}