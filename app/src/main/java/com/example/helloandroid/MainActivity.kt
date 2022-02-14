package com.example.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var helloEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloBtn: Button = findViewById(R.id.hello_button)
        helloBtn.setOnClickListener(this::sayHello)

        val spinner = findViewById<Spinner>(R.id.my_spinner)
        val adapter = ArrayAdapter.createFromResource(
            this, R.array.sizes_array, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val item = parent.getItemAtPosition(position) as String
                Toast.makeText(this@MainActivity, item, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        //val x= 1/0
        helloEditText = findViewById(R.id.name_edit_text)
        helloEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                val helloTextView = findViewById<TextView>(R.id.hello_text_view)

                // Get the string from strings.xml
                val helloText = getString(R.string.hello_message, s)

                // Put the "Hello NAME" string in the UI
                helloTextView.text = helloText
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    fun sayHello(view: View) {
        // Extract the text from EditText
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