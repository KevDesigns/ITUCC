package com.example.projectucc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.auth.User

class Courses : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    lateinit var courseArrayList: ArrayList<CourseData>
    private lateinit var courseAdapter: CourseAdapter
    private lateinit var db:FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)


        recyclerView=findViewById(R.id.recyclerView2)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        courseArrayList= arrayListOf()

        courseAdapter= CourseAdapter(courseArrayList)
        recyclerView.adapter=courseAdapter
        EventChangeListener()
    }

    private fun EventChangeListener(){
        db=FirebaseFirestore.getInstance()
        db.collection("Course").
                addSnapshotListener(object: EventListener<QuerySnapshot>{
                    override fun onEvent(
                        value:QuerySnapshot?,
                        error:FirebaseFirestoreException?
                    )
                    {
                        if(error!= null){
                            Log.e("Error! Please try again.",error.message.toString())
                            return
                        }

                        for (dc:DocumentChange in value?.documentChanges!!){
                            if (dc.type==DocumentChange.Type.ADDED){
                                courseArrayList.add(dc.document.toObject(CourseData::class.java))
                            }
                        }

                        courseAdapter.notifyDataSetChanged()

                    }
                })
    }
}