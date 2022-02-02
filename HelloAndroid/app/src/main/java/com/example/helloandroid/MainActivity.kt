package com.example.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sayHello(view: View) {
        // Extract the text from EditText
        val helloEditText = findViewById<EditText>(R.id.name_edit_text)
        val name = helloEditText.text

        // Put "Hello " + name in TextView
        val helloTextView = findViewById<TextView>(R.id.hello_text_view)
        helloTextView.text = "Hello $name"

        Log.d("test", "This is a test")

        Toast.makeText(this, "Hello $name", Toast.LENGTH_SHORT).show()
    }
}