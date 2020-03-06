package com.chepra.mvptodo.Database;

import com.chepra.mvptodo.main.mvpPackage.MainMVP;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "Task")
public class TaskModel{

    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "title")
    private String title;
    @Property(nameInDb = "description")
    private String description;
    @Property(nameInDb = "value")
    private int value;
    @Property(nameInDb = "done")
    private boolean done;

    @Generated(hash = 332930535)
    public TaskModel(Long id, String title, String description, int value,
            boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.value = value;
        this.done = done;
    }

    @Generated(hash = 648620828)
    public TaskModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean getDone() {
        return this.done;
    }
}
