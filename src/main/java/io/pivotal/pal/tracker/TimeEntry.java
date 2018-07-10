package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    //static long id_sub=0;
    public TimeEntry(long l, long l1, LocalDate parse, int i) {
        //id_sub++;
        this.id = -1;
        this.projectId=l;
        this.userId=l1;
        this.date=parse;
        this.hours=i;
    }

    public TimeEntry(long l, long l1, long l2, LocalDate parse, int i) {
        this.id=l;
        this.projectId=l1;
        this.userId=l2;
        this.date=parse;
        this.hours=i;

    }

    public TimeEntry() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public long getProjectId() {

        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
