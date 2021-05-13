package com.example.soccerleauge.db

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.soccerleauge.model.Teams

@Database(entities = [Teams::class],version = 1,exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun dao() : Dao
}