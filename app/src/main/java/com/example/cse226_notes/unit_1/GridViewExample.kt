package com.example.cse226_notes.unit_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_notes.R

class GridViewExample : AppCompatActivity() {

    private var list = ArrayList<GridViewDataModel>()
    var myAdap: GridViewAdapter? = null
    lateinit var gridView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view_example)

        gridListData()
        gridView = findViewById(R.id.gridView)
        gridView.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(this, 2)
        gridLayoutManager.orientation = RecyclerView.VERTICAL
        gridView.layoutManager = gridLayoutManager
        myAdap = GridViewAdapter(this, list)
        gridView.adapter = myAdap
    }

    private fun gridListData() {

        list = ArrayList<GridViewDataModel>()
        list.add(GridViewDataModel("One", R.drawable.minion_1))
        list.add(GridViewDataModel("Two", R.drawable.minion_2))
        list.add(GridViewDataModel("Three", R.drawable.minion_3))
        list.add(GridViewDataModel("Four", R.drawable.minion_4))
        list.add(GridViewDataModel("Five", R.drawable.minion_1))
        list.add(GridViewDataModel("Six", R.drawable.minion_2))
        list.add(GridViewDataModel("Seven", R.drawable.minion_3))
        list.add(GridViewDataModel("Eight", R.drawable.minion_4))
    }

}