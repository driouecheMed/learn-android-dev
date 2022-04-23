package com.driouechemed.basickotlinapp.database.entities

import java.util.*

data class Task(
    val uuid: String = UUID.randomUUID().toString(),
    var name: String,
    var details: String?
)
