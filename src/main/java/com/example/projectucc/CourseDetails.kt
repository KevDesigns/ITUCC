package com.example.projectucc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.firestore.*

class CourseDetails : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)
        setCourseDetails()


    }

    private fun setCourseDetails(){
        var arrayPosition= intent.getIntExtra("position",0)
        lateinit var db:FirebaseFirestore
        lateinit var courseArrayList: ArrayList<CourseData>

        val courseCodeTextView:TextView=findViewById(R.id.course_details_course_code)
        val courseNameTextView:TextView=findViewById(R.id.course_details_course_name)
        val courseCreditsTextView:TextView=findViewById(R.id.course_details_course_credits)
        val coursePreRequisitesTextView:TextView=findViewById(R.id.course_details_prerequsites)
        val courseDescriptionTextView:TextView=findViewById(R.id.course_details_course_description)

        courseArrayList= arrayListOf()


        db= FirebaseFirestore.getInstance()
        db.collection("Course").
        addSnapshotListener(object: EventListener<QuerySnapshot> {
            override fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            )
            {
                if(error!= null){
                    Log.e("Firestore Error",error.message.toString())
                    return
                }

                for (dc: DocumentChange in value?.documentChanges!!){
                    if (dc.type== DocumentChange.Type.ADDED){
                        var i=0
                        courseArrayList.add(dc.document.toObject(CourseData::class.java))

                        while(i<courseArrayList.size) {
                            if (i==arrayPosition) {
                                courseCodeTextView.text =
                                    "Course Code: " + courseArrayList[arrayPosition].CourseCode
                                courseNameTextView.text =
                                    "Course Title: " + courseArrayList[arrayPosition].CourseName
                                courseCreditsTextView.text =
                                    "Course Credits: " + courseArrayList[arrayPosition].Credits
                                coursePreRequisitesTextView.text =
                                    "Course Pre-Requisites: " + courseArrayList[arrayPosition].PreRequisites
                                courseDescriptionTextView.text =
                                    "Course Description: " + courseArrayList[arrayPosition].Description
                                break
                            }

                            i++
                        }
                    }
                }


            }
        })









    }
}