package com.example.cse226_notes.unit_1

class RecyclerViewDataModel
    (semester: String?, cgpa: String?, year: String?) {

    private var semester: String
    private var cgpa: String
    private var year: String

    init {
        this.semester = semester!!
        this.cgpa = cgpa!!
        this.year = year!!
    }

    fun getTitle(): String{
        return semester
    }

    fun getGenre(): String{
        return cgpa
    }

    fun getYear(): String{
        return year
    }
}