package com.example.testinglearning

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val TOAST_TEXT = "aaaa"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.show_toast_button).setOnClickListener {
            Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG).show()
        }
    }
}