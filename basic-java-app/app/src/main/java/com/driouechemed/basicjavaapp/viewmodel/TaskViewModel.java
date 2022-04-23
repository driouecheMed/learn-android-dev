package com.driouechemed.basicjavaapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.driouechemed.basicjavaapp.database.AppDatabase;
import com.driouechemed.basicjavaapp.database.entities.Task;
import com.driouechemed.basicjavaapp.repository.TaskRepository;

import io.reactivex.schedulers.Schedulers;

public class TaskViewModel extends AndroidViewModel {

    private final TaskRepository taskRepository;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(AppDatabase.getAppDatabase(application));
    }

    public void insert(Task task) {
        taskRepository.insert(task).subscribeOn(Schedulers.io()).subscribe();
    }

}
