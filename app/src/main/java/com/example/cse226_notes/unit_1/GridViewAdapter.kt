package com.example.cse226_notes.unit_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_notes.R

class GridViewAdapter(var c: Context, var list: ArrayList<GridViewDataModel>):
    RecyclerView.Adapter<GridViewAdapter.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var image: ImageView
        var click: LinearLayout

        init {
            name = itemView.findViewById(R.id.name)
            image = itemView.findViewById(R.id.img)
            click = itemView.findViewById(R.id.click)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val inflater: View = LayoutInflater.from(c).
            inflate(R.layout.custom_grid_view, parent, false)

        return MyHolder(inflater)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.name.text = list[position].name
        holder.image.setImageResource(list[position].image)
        holder.click.setOnClickListener {
            Toast.makeText(c, "Clicked ${list[position].name}", Toast.LENGTH_SHORT).show()
        }
    }
}