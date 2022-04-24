package com.driouechemed.basickotlinapp.database.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "task")
data class Task(
    @NonNull @PrimaryKey val uuid: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "details") var details: String?
)
