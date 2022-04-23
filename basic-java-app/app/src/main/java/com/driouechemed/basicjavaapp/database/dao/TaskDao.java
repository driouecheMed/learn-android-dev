package com.driouechemed.basicjavaapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.driouechemed.basicjavaapp.database.entities.Task;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface TaskDao {

    @Insert
    Completable insertTask(Task task);

    @Query("SELECT * FROM task")
    Observable<List<Task>> getAllTasks();
}
