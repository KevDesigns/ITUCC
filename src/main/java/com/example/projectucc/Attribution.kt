package com.example.projectucc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Attribution : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attribution)

        val studyingAttribution: TextView = findViewById(R.id.studyingAttribution)
        val bookAttribution: TextView = findViewById(R.id.bookAttribution)
        val paperAttribution: TextView = findViewById(R.id.paperAttribution)
        val socialMediaAttribution: TextView = findViewById(R.id.socialMediaAttribution)
        val attributionIcon: TextView = findViewById(R.id.attributionIcon)
        val maleProfilePictureAttribution: TextView = findViewById(R.id.maleProfilePictureAttribution)
        val femaleProfilePictureAttribution: TextView = findViewById(R.id.femaleProfilePictureAttribution)
        val instagramIconAttribution: TextView = findViewById(R.id.instagramIconAttribution)
        val facebookIconAttribution: TextView = findViewById(R.id.facebookIconAttribution)
        val twitterIconAttribution: TextView = findViewById(R.id.twitterIconAttribution)
        val youtubeIconAttribution: TextView = findViewById(R.id.youtubeIconAttribution)

        studyingAttribution.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.com/free-icons/studying")))
        }

        bookAttribution.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.com/free-icons/book")))
        }

        paperAttribution.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.com/free-icons/paper")))
        }

        socialMediaAttribution.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.com/free-icons/socialmedia")))
        }


        attributionIcon.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.com/free-icons/information")))
        }

        maleProfilePictureAttribution.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.com/free-icons/profile")))
        }

        femaleProfilePictureAttribution.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.com/free-icons/woman")))
        }

        instagramIconAttribution.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.com/free-icons/instagram")))
        }

        facebookIconAttribution.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.com/free-icons/facebook")))
        }

        twitterIconAttribution.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.com/free-icons/twitter")))
        }

        youtubeIconAttribution.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.com/free-icons/youtube")))
        }

    }
}