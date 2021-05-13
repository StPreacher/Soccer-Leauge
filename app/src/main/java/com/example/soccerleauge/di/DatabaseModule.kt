package com.example.soccerleauge.di

import android.content.Context
import androidx.room.Room
import com.example.soccerleauge.db.Dao
import com.example.soccerleauge.db.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDao(database: Database) : Dao{
        return database.dao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext : Context) : Database {
        return Room.databaseBuilder(appContext,
        Database::class.java,
        "team_info").build()
    }

}