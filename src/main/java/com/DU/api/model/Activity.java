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
@Table(name = "Activity")
public class Activity {
 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "activity_id")
private Long activity_id;

@Column(name = "activity")
private String activity;

@Column(name = "ActivityType")
private String ActivityType;

    public Activity() {
    }

    public Activity(Long activity_id, String activity, String ActivityType) {
        this.activity_id = activity_id;
        this.activity = activity;
        this.ActivityType = ActivityType;
    }

    public Long getActivity_id() {
        return this.activity_id;
    }

    public void setActivity_id(Long activity_id) {
        this.activity_id = activity_id;
    }

    public String getActivity() {
        return this.activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getActivityType() {
        return this.ActivityType;
    }

    public Activity activity_id(Long activity_id) {
        setActivity_id(activity_id);
        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) o;
        return Objects.equals(activity_id, activity.activity_id) && Objects.equals(activity, activity.activity) && Objects.equals(ActivityType, activity.ActivityType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activity_id, activity, ActivityType);
    }

    @Override
    public String toString() {
        return "{" +
            " activity_id='" + getActivity_id() + "'" +
            ", activity='" + getActivity() + "'" +
            ", ActivityType='" + getActivityType() + "'" +
            "}";
    }

}  

