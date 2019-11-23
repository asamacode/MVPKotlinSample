package com.asama.luong.mvpkotlinsample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asama.luong.mvpkotlinsample.data.database.repository.option.OptionDao
import com.asama.luong.mvpkotlinsample.data.database.repository.option.Options
import com.asama.luong.mvpkotlinsample.data.database.repository.question.Question
import com.asama.luong.mvpkotlinsample.data.database.repository.question.QuestionDao

@Database(entities = [(Question::class), (Options::class)], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun optionDao(): OptionDao

    abstract fun questionDao(): QuestionDao
}