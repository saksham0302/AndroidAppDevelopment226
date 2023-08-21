package com.example.cse226_notes.unit_2

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.cse226_notes.R
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class DownloadImage : AppCompatActivity() {

    lateinit var imageURL: URL
    var `is`: InputStream? = null
    lateinit var downloadImage: ImageView
    private lateinit var download: Button
    lateinit var progressDialog: ProgressDialog
    var bitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_image)

        download = findViewById(R.id.download)
        downloadImage = findViewById(R.id.downloadImage)

        download.setOnClickListener {
            val asyncTask: AsyncTaskExample = AsyncTaskExample()
            asyncTask.execute("https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg")
        }

    }

    @SuppressLint("StaticFieldLeak")
    private inner class AsyncTaskExample :
        AsyncTask<String?, String?, Bitmap?>() {

        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog = ProgressDialog(this@DownloadImage)
            progressDialog.setMessage("Please wait...It is downloading")
            progressDialog.setCancelable(false)
            progressDialog.show()
        }

        override fun doInBackground(vararg params: String?): Bitmap? {

            try {
                imageURL = URL(params[0])
                val conn: HttpURLConnection =
                    imageURL.openConnection() as HttpURLConnection
                conn.setDoInput(true)
                conn.connect()
                `is` = conn.inputStream
                val option = BitmapFactory.Options()
                option.inPreferredConfig = Bitmap.Config.RGB_565
                bitmap = BitmapFactory.decodeStream(`is`, null, option)

            } catch (e: IOException) {
                e.printStackTrace()
            }
            return bitmap
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)

            if (downloadImage != null) {
                progressDialog.hide()
                downloadImage.setImageBitmap(result)
            } else {
                progressDialog.show()
            }
        }
    }

}