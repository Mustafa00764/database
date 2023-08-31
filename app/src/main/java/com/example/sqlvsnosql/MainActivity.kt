package com.example.sqlvsnosql

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.sqlvsnosql.data.local.UserRepository
import com.example.sqlvsnosql.model.User
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    lateinit var tvTest:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val repository=UserRepository(application)
        val bSave = findViewById<Button>(R.id.bSave)
        val et_username = findViewById<EditText>(R.id.et_username)
        val et_password = findViewById<EditText>(R.id.et_password)
        val et_number = findViewById<EditText>(R.id.et_number)
        val bLoad = findViewById<Button>(R.id.bLoad)
        tvTest=findViewById(R.id.tv_test)

        bSave.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()
            val number = et_number.text.toString()
            val user= User(null,username,password,number)
            repository.saveUser(user)
        }

        bLoad.setOnClickListener {
            val users = repository.getAllUsers()
            Log.d("@@@@","initViews: $users")
        }

    }

    @SuppressLint("SetTextI18n")
    private fun userExecutor(repository: UserRepository, user: User) {
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        executor.execute{
            repository.saveUser(user)
            handler.post{
                tvTest.text = "Ma'lumot saqlandi"
            }
        }
    }
}