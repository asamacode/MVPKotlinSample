package com.asama.luong.mvpkotlinsample.data.database.repository.question

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(question: List<Question>)

    @Query("SELECT * FROM questions")
    fun loadAll(): List<Question>
}