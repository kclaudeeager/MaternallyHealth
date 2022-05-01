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

    @Column(name = "activity")
    private String activity;

    @Column(name = "Food", nullable = false)
    private Integer food;


    @Column(name = "DoctorAdvise", nullable = false)
    private Integer DoctorAdvise;

    @Column(name = "Sport", nullable = false)
    private Integer sport;

    public Tips() {
        super();
    }

    public Tips(Long id, String activity, Integer food, Integer DoctorAdvise, Integer sport) {
        this.id = id;
        this.activity = activity;
        this.food = food;
        this.DoctorAdvise = DoctorAdvise;
        this.sport = sport;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivity() {
        return this.activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Integer getFood() {
        return this.food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Integer getDoctorAdvise() {
        return this.DoctorAdvise;
    }

    public void setDoctorAdvise(Integer DoctorAdvise) {
        this.DoctorAdvise = DoctorAdvise;
    }

    public Integer getSport() {
        return this.sport;
    }

    public void setSport(Integer sport) {
        this.sport = sport;
    }

    public Tips id(Long id) {
        setId(id);
        return this;
    }

    public Tips activity(String activity) {
        setActivity(activity);
        return this;
    }

    public Tips food(Integer food) {
        setFood(food);
        return this;
    }

    public Tips DoctorAdvise(Integer DoctorAdvise) {
        setDoctorAdvise(DoctorAdvise);
        return this;
    }

    public Tips sport(Integer sport) {
        setSport(sport);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tips)) {
            return false;
        }
        Tips tips = (Tips) o;
        return Objects.equals(id, tips.id) && Objects.equals(activity, tips.activity) && Objects.equals(food, tips.food) && Objects.equals(DoctorAdvise, tips.DoctorAdvise) && Objects.equals(sport, tips.sport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activity, food, DoctorAdvise, sport);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", activity='" + getActivity() + "'" +
            ", food='" + getFood() + "'" +
            ", DoctorAdvise='" + getDoctorAdvise() + "'" +
            ", sport='" + getSport() + "'" +
            "}";
    }


}

