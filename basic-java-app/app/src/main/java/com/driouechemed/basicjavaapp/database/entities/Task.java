package com.driouechemed.basicjavaapp.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "task")
public class Task {

    @PrimaryKey
    @ColumnInfo(name = "uuid")
    private final String uuid;

    @ColumnInfo(name = "task_name")
    private String taskName;

    @ColumnInfo(name = "task_details")
    private String taskDetails;

    public Task() {
        uuid = UUID.randomUUID().toString();
    }

    @Ignore
    public Task(String taskName, String taskDetails) {
        this();
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
