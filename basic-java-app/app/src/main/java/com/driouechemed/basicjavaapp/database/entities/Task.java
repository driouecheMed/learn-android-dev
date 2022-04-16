package com.driouechemed.basicjavaapp.database.entities;

import org.apache.commons.lang3.StringUtils;

public class Task {

    private String taskName;

    private String taskDetails;

    public Task() {
        taskName = StringUtils.EMPTY;
        taskDetails = StringUtils.EMPTY;
    }

    public Task(String taskName, String taskDetails) {
        this.taskName = taskName;
        this.taskDetails = taskDetails;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }
}
