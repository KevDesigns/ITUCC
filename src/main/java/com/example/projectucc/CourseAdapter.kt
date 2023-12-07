package com.example.projectucc


import android.content.Context
import android.content.Intent
import android.icu.lang.UCharacter.getAge
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import java.security.AccessController.getContext

class CourseAdapter (private val courseList:ArrayList<CourseData>): RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.course_item,parent,false)
        return CourseViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return courseList.size
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val courseData = courseList[position]
        holder.courseCode.text=courseData.CourseCode
        holder.courseName.text=courseData.CourseName
    }

    class CourseViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val courseCode: TextView = itemView.findViewById(R.id.course_code)
        val courseName: TextView = itemView.findViewById(R.id.course_name)


        init{
            itemView.setOnClickListener{

                val intent = Intent(itemView.getContext(), CourseDetails::class.java).also{
                    it.putExtra("position",adapterPosition)
                    itemView.getContext().startActivity(it)


                }
            }

        }
    }
}