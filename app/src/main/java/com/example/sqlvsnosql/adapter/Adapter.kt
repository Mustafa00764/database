package com.example.sqlvsnosql.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlvsnosql.R

class Adapter:RecyclerView.Adapter<Adapter.UserViewHolder>() {


    class UserViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tvUsername = view.findViewById<TextView>(R.id.tv_userName)
    }
}