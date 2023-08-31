package com.example.sqlvsnosql.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sqlvsnosql.model.User

@Dao
interface UserDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user:User)

    @Query("SELECT * FROM users")
    fun loadUsers():List<User>


    @Query("SELECT * FROM users WHERE id=:id")
    fun getUserById(id:Int):User



    @Query("DELETE FROM users WHERE id=:id")
    fun deleteUserById(id:Int)

    @Delete
    fun deleteUser(user: User)

}