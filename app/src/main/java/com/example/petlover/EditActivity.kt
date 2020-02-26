package com.example.petlover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*


class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        cancle.setOnClickListener {
            val intent = Intent(this, Bottomnavigation::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
