package com.example.cse226_notes.unit_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.cse226_notes.R

class StaticWebViewExample : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_web_view_example)

        webView = findViewById(R.id.webView)

        val customHtml = """
            <html>
                <body>
                    <h1>Welcome to 99Acres</h1>
                    <h2>Find your next home.</h2>
                    <h3>Or get a land to build your own house.</h3>
                    <p>It's a static Web HTML Content.</p>
                </body>
            </html>
        """.trimIndent()

        webView.loadData(customHtml, "text/html", "UTF-8")
    }
}