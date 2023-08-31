package com.example.sqlvsnosql.data.local

import android.app.Application
import com.example.sqlvsnosql.model.User

class UserRepository(val application: Application) {
    val userDao=AppDatabase.appDatabase(application).getUserDao()

    fun getAllUsers(): List<User>{
        return userDao.loadUsers()
    }

    fun getUserById(id:Int):User{
        return userDao.getUserById(id)
    }

    fun saveUser(user: User){
        userDao.saveUser(user)
    }

    fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

}