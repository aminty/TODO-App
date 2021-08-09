package entity;

import base.entity.BaseEntity;
import entity.enumeration.ActivityStatus;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Activity extends BaseEntity {
    @Column()
    @Enumerated(EnumType.STRING)
    private ActivityStatus status;
    @Column
    private String activityName;
    @Column
    private Date date;
    @ManyToOne
    private User user;


    public Activity() {

    }

    public Activity(ActivityStatus status, String activityName, Date date, User user) {
        this.status = status;
        this.activityName = activityName;
        this.date = date;
        this.user = user;
    }

    @Override
    public int getId() {
        return super.getId();
    }
    @Override
    public void setId(int integer) {
        super.setId(integer);
    }

    public ActivityStatus getStatus() {
        return status;
    }

    public void setStatus(ActivityStatus status) {
        this.status = status;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
