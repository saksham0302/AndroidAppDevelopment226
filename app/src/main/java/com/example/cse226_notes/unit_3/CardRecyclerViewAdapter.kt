package com.example.cse226_notes.unit_3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_notes.R

class CardRecyclerViewAdapter(
    var c: Context,
    private var list: ArrayList<CardRecyclerViewDataModel>
) :
    RecyclerView.Adapter<CardRecyclerViewAdapter.MyHolderDemo>() {

    class MyHolderDemo(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.personImg)
        var name: TextView = itemView.findViewById(R.id.personName)
        var contact: TextView = itemView.findViewById(R.id.personMobile)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolderDemo {

        val inflater = LayoutInflater.from(c)
            .inflate(R.layout.custom_card_recycler_view, parent, false)

        return MyHolderDemo(inflater)
    }

    override fun onBindViewHolder(holder: MyHolderDemo, position: Int) {

        val data = list[position]
        holder.image.setImageResource(data.image)
        holder.name.text = data.name
        holder.contact.text = data.contact
    }

    override fun getItemCount(): Int {

        return list.size
    }
}