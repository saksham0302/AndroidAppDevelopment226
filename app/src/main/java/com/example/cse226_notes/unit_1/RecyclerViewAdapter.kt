package com.example.cse226_notes.unit_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_notes.R

class RecyclerViewAdapter (var list: MutableList<RecyclerViewDataModel>):
    RecyclerView.Adapter<RecyclerViewAdapter.MyHolderDemo>() {

    class MyHolderDemo(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var semester: TextView = itemView.findViewById(R.id.semester)
        var cgpa: TextView = itemView.findViewById(R.id.cgpa)
        var year: TextView = itemView.findViewById(R.id.year)
        var delete: Button = itemView.findViewById(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderDemo {

        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_recycler_view,parent,false)

        return MyHolderDemo(inflater)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: MyHolderDemo, position: Int) {

        val data = list[position]
        holder.semester.text = data.getTitle()
        holder.cgpa.text = data.getGenre()
        holder.year.text = data.getYear()

        holder.delete.setOnClickListener {
            val itemSelected = list.get(position)
            list.remove(itemSelected)
            notifyDataSetChanged()
        }
    }
}