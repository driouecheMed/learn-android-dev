package com.driouechemed.basicjavaapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.driouechemed.basicjavaapp.database.dao.TaskDao;
import com.driouechemed.basicjavaapp.database.entities.Task;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "basic-app.db";
    private static AppDatabase instance;

    public static AppDatabase getAppDatabase(Context context) {
        if (instance == null) {
            Builder<AppDatabase> builder = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, DATABASE_NAME);
            instance = builder.build();
        }
        return instance;
    }

     public abstract TaskDao getTaskDao();
}
