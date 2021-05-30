package com.my_company.time_manager.model;




import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "activity")
public class Activity extends BaseEntity {
    private String name;
    private Date start_time, end_time;
    private Time duration;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_admin")
    Admin admin;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    Category category;

    @ManyToMany(mappedBy = "activities", fetch = FetchType.EAGER)
    List<User> users;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }



    public Activity() {
    }

    public Activity(String name, Date start_time, Date end_time, Time duration) {
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.duration = duration;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }



}
