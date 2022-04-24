package com.driouechemed.basicjavaapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.driouechemed.basicjavaapp.database.AppDatabase;
import com.driouechemed.basicjavaapp.database.entities.Task;
import com.driouechemed.basicjavaapp.repositories.TaskRepository;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TaskViewModel extends AndroidViewModel {

    private final TaskRepository taskRepository;
    private final MutableLiveData<List<Task>> tasksLiveData = new MutableLiveData<>();

    public TaskViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(AppDatabase.getAppDatabase(application));
    }

    public LiveData<List<Task>> getTasks() {
        return tasksLiveData;
    }

    public void insert(Task task) {
        taskRepository.insert(task).subscribeOn(Schedulers.io()).subscribe();
    }

    public void getTasksFromDb() {
        taskRepository.getAllTasks()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Task>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // Subscribe
                    }

                    @Override
                    public void onNext(List<Task> tasks) {
                        tasksLiveData.setValue(tasks);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        // onComplete
                    }
                });
    }
}
