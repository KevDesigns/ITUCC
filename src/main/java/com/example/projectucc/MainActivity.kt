package com.example.projectucc

import android.content.Intent
import android.content.pm.Attribution
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var faculty: ImageButton = findViewById(R.id.faculty)
        var courses: ImageButton = findViewById(R.id.courses)
        var admissions: ImageButton = findViewById(R.id.admissions)
        var socialMedia: ImageButton = findViewById(R.id.socialmedia)
        var email: ImageButton = findViewById(R.id.floatingActionButton2)
        val attribution: ImageView = findViewById(R.id.attribution)

        faculty.setOnClickListener{
            var intent = Intent(this, Directory::class.java)
            startActivity(intent)
        }

        courses.setOnClickListener{
            var intent = Intent(this, Courses::class.java)
            startActivity(intent)
        }

        admissions.setOnClickListener {
            var intent = Intent(this, Admissions::class.java)
            startActivity(intent)
        }

        socialMedia.setOnClickListener {
            var intent = Intent(this, SocialMedia::class.java)
            startActivity(intent)
        }

        email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("deanmst@ucc.edu.jm"))
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Choose an Email address :"))
        }

        attribution.setOnClickListener{
            var intent = Intent(this, com.example.projectucc.Attribution::class.java)
            startActivity(intent)
        }

    }
}