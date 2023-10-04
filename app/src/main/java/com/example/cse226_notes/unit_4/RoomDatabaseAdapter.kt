package com.example.cse226_notes.unit_4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.cse226_notes.R

class RoomDatabaseAdapter(
    var mCtx: Context,
    var resources: Int,
    var items: List<RoomDatabaseContact>
) :
    ArrayAdapter<RoomDatabaseContact>(mCtx, resources, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources, null)
        val name: TextView = view.findViewById(R.id.nameListItem)
        val id: TextView = view.findViewById(R.id.idListItem)
        val contact: TextView = view.findViewById(R.id.noListItem)

        val mItem: RoomDatabaseContact = items[position]
        name.text = mItem.name
        contact.text = mItem.phone.toString()
        id.text = mItem.id.toString()

        return view
    }
}