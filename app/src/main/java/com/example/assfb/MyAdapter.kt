package com.example.assfb

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MyAdapter(private val NoteList: ArrayList<notemodel>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class  ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var txttitel : TextView = itemView.findViewById(R.id.txttitel)
        val desnote : TextView = itemView.findViewById(R.id.txtdesc)
        val numbdesc : TextView = itemView.findViewById(R.id.txtnumb)

    }

     @SuppressLint("SuspiciousIndentation")
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_rec, parent,false)
            return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:  ViewHolder, position: Int) {
        val  ItemsViewModel  = NoteList[position]

        holder.txttitel.text = ItemsViewModel.titel
        holder.desnote.text = ItemsViewModel.desc
        holder.numbdesc.text= ItemsViewModel.numb
    }


    override fun getItemCount(): Int {
        return NoteList.size
    }

}
