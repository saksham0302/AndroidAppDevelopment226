package com.example.cse226_notes.unit_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.cse226_notes.R

class CustomListViewAdapter
    (context: Context, var resource: Int, var objects: MutableList<CustomListViewDataModel>) :
    ArrayAdapter<CustomListViewDataModel>(context, resource, objects) {

    lateinit var cb: CheckBox
    fun isChecked(position: Int): Boolean {
        return objects.get(position).checked
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(resource, null)
        val imageView: ImageView = view.findViewById(R.id.image)
        val titleTextView: TextView = view.findViewById(R.id.textView1)
        val descTextView: TextView = view.findViewById(R.id.textView2)
        val button: Button = view.findViewById(R.id.button)
        cb = view.findViewById(R.id.checkBox)

        val myItem: CustomListViewDataModel = objects[position]

        imageView.setImageDrawable(context.resources.getDrawable(myItem.image))
        titleTextView.text = myItem.title
        descTextView.text = myItem.desc

        button.tag = position
        button.setOnClickListener {
            val itemSelected = objects.get(it.tag as Int)
            objects.remove(itemSelected)
            notifyDataSetChanged()
        }

        cb.setChecked(objects.get(position).checked)
        cb.setTag(position)
        val itemStr = objects.get(position).title
        cb.setOnClickListener(View.OnClickListener {
            val newState: Boolean = !objects.get(position).isChecked()
            objects.get(position).checked = newState
            Toast.makeText(context, itemStr + " selected with state: " + newState
                , Toast.LENGTH_LONG).show()
        })
        cb.setChecked(isChecked(position))

        return view
    }
}