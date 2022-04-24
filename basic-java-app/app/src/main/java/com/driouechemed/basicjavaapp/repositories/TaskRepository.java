package com.driouechemed.basicjavaapp.repositories;

import com.driouechemed.basicjavaapp.database.AppDatabase;
import com.driouechemed.basicjavaapp.database.entities.Task;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class TaskRepository {

    private final AppDatabase appDatabase;

    public TaskRepository(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    public Completable insert(Task task) {
        return appDatabase.getTaskDao().insertTask(task);
    }

    public Observable<List<Task>> getAllTasks() {
        return appDatabase.getTaskDao().getAllTasks();
    }
}
