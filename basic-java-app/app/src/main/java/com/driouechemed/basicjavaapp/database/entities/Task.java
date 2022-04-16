package com.driouechemed.basicjavaapp.database.entities;

import org.apache.commons.lang3.StringUtils;

public class Task {

    private String taskName;

    private Integer TaskPriority;

    public Task() {
        taskName = StringUtils.EMPTY;
        TaskPriority = 0;
    }

    public Task(String taskName, Integer taskPriority) {
        this.taskName = taskName;
        TaskPriority = taskPriority;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskPriority() {
        return TaskPriority;
    }

    public void setTaskPriority(Integer taskPriority) {
        TaskPriority = taskPriority;
    }
}
