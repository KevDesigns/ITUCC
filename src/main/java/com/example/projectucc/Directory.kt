package com.example.projectucc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Directory : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList:ArrayList<Faculty>
    lateinit var profilePicture:Array<Int>
    lateinit var name:Array<String>
    lateinit var phoneNumber:Array<String>
    lateinit var emailAddress:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_directory)

        profilePicture= arrayOf(
            R.drawable.natrose,
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.woman,
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.woman,
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.woman
        )

        name= arrayOf(
            "Natalie Rose (HOD)",
            "Henry Osbourne",
            "Otis Osbourne",
            "Pamella Reid",
            "Ricardo Reid",
            "Craig Wilmot",
            "Bryanna Chang",
            "Ian Seymour",
            "Neil Williams",
            "Winsome Bennett"
        )

        phoneNumber = arrayOf(
            "876 415 2974",
            "876 323 7719",
            "876 878 0095",
            "876 324 5678",
            "876 890 1234",
            "876 543 2109",
            "876 789 0123",
            "876 456 7890",
            "876 231 0987",
            "876 987 6543"
        )

        emailAddress= arrayOf(
            "deanmst@ucc.edu.jm",
            "hosbourne@ucc.edu.jm",
            "itfaculty@ucc.edu.jm",
            "itprogrammeofficer2@ucc.edu.jm",
            "itprogrammeofficer3@ucc.edu.jm",
            "itprogofficer4@ucc.edu.jm",
            "changbry@ucc.edu.jm",
            "roadmourian@ucc.edu.jm",
            "itlecturer@ucc.edu.jm",
            "itprogrammeofficer@ucc.edu.jm"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<Faculty>()
        getUserData()
    }
    private fun getUserData(){

        for (i in profilePicture.indices){
            val facultyList = Faculty(profilePicture[i],name[i],phoneNumber[i],emailAddress[i])
            newArrayList.add(facultyList)
        }

        var adapter=Adapter(newArrayList)
        newRecyclerView.adapter=adapter

        adapter.setOnItemClickListener (
            object:Adapter.PhoneNumberListener{
                override fun phoneNumberClick(position: Int) {

                    val intent = Intent(Intent.ACTION_DIAL).also {
                        it.setData(Uri.parse("tel:${phoneNumber[position]}"))
                        startActivity(it)
                    }
                }


            },

            object:Adapter.EmailAddressListener{
                override fun emailAddressClick(position: Int) {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("${emailAddress[position]}"))
                    intent.type = "message/rfc822"
                    startActivity(Intent.createChooser(intent, "Choose an Email Address :"))

                }
            }
        )


    }
}