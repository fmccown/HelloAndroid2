package com.example.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloBtn = findViewById<Button>(R.id.hello_button)
        helloBtn.setOnClickListener(this::sayHello)

        //val x= 1/0

    }

    fun sayHello(view: View) {
        // Extract the text from EditText
        val helloEditText = findViewById<EditText>(R.id.name_edit_text)
        val name = helloEditText.text

        Log.d("test", "This is a test")

        // Put "Hello " + name in TextView
        val helloTextView = findViewById<TextView>(R.id.hello_text_view)

        // Get the string from strings.xml
        val helloText = getString(R.string.hello_message, name)

        // Put the "Hello NAME" string in the UI
        helloTextView.text = helloText
        Toast.makeText(this, helloText, Toast.LENGTH_SHORT).show()
    }
}