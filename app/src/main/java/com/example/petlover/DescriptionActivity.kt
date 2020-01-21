package com.example.petlover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_description.*
import kotlinx.android.synthetic.main.activity_edit.*

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        chat.setOnClickListener {
            val intent = Intent(this, Chat::class.java)
            // start your next activity
            startActivity(intent)
        }
        map.setOnClickListener {
            val intent = Intent(this, Navigate::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
