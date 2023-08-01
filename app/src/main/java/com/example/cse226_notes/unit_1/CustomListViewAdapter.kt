package com.example.cse226_notes.unit_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.cse226_notes.R

class CustomListViewAdapter(context: Context, var resource: Int, var objects: MutableList<CustomListViewDataModel>) :
    ArrayAdapter<CustomListViewDataModel>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(resource, null)
        val imageView: ImageView = view.findViewById(R.id.image)
        val titleTextView: TextView = view.findViewById(R.id.textView1)
        val descTextView: TextView = view.findViewById(R.id.textView2)

        val myItem: CustomListViewDataModel = objects[position]

        imageView.setImageDrawable(context.resources.getDrawable(myItem.image))
        titleTextView.text = myItem.title
        descTextView.text = myItem.desc

        return view
    }
}