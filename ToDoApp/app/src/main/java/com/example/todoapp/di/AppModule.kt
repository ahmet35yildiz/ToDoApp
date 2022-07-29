package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.repo.TasksDaoRepository
import com.example.todoapp.room.Database
import com.example.todoapp.room.TasksDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTasksDaoRepository(tdao:TasksDao) : TasksDaoRepository {
        return TasksDaoRepository(tdao)
    }

    @Provides
    @Singleton
    fun provideTasksDao(@ApplicationContext context: Context) : TasksDao {
        val db = Room.databaseBuilder(context,Database::class.java,"toDoApp.sqlite").createFromAsset("toDoApp.sqlite").build()
        return db.getTasksDao()
    }
}