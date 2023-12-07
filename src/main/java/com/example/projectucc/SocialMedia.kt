package com.example.projectucc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SocialMedia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_media)

        val instagram:ImageView=findViewById(R.id.instagram)
        val facebook:ImageView=findViewById(R.id.facebook)
        val twitter:ImageView=findViewById(R.id.twitter)
        val youtube:ImageView=findViewById(R.id.youtube)

        instagram.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/uccjamaica/")))
        }

        facebook.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/uccjamaica/")))
        }

        twitter.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/UCCjamaica")))
        }

        youtube.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/uccjamaica")))
        }


    }
}