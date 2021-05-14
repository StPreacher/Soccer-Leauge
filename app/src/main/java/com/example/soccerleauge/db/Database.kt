package com.example.soccerleauge.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.soccerleauge.model.TeamResponse

@Database(entities = [TeamResponse::class],version = 2,exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun dao() : Dao
}