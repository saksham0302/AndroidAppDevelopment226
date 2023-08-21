package com.example.cse226_notes.unit_2

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import com.example.cse226_notes.R

class AsyncTaskExample : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    private lateinit var listView: ListView
    var arr = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
    lateinit var arrayAdapter: ArrayAdapter<String>
    lateinit var arrayList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task_example)

        progressBar = findViewById(R.id.progressBar)
        listView = findViewById(R.id.listView)
        arrayList = ArrayList()
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        listView.adapter = arrayAdapter
        MyTaskDemo().execute()

    }

    internal inner class MyTaskDemo : AsyncTask<Void, Int?, String?>() {
        private var count = 0
        override fun onPreExecute() {
            progressBar.max = 10
            progressBar.progress = 0
            progressBar.visibility = View.VISIBLE
            count = 0
        }

        override fun doInBackground(vararg p0: Void?): String? {

            for (i in 1..10) {
                count += 1
                publishProgress()
                try {
                    Thread.sleep(1000)
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }

            return "Task Completed"
        }

        override fun onProgressUpdate(vararg values: Int?) {

            super.onProgressUpdate(*values)
            progressBar.progress = values[0]!!
            arrayList.add(arr[count - 1])
            arrayAdapter.notifyDataSetChanged()
        }

        override fun onPostExecute(result: String?) {

            super.onPostExecute(result)
            Toast.makeText(this@AsyncTaskExample, result, Toast.LENGTH_LONG).show()
            progressBar.visibility = View.INVISIBLE
        }

    }

}