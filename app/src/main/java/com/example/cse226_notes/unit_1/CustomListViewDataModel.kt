package com.example.cse226_notes.unit_1

class CustomListViewDataModel
    (val title: String, val desc: String, val image: Int, var checked: Boolean) {

        fun isChecked() : Boolean {
            return checked
        }
}