package com.example.projectucc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val facultyList:ArrayList<Faculty>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var phoneNumberListener: PhoneNumberListener
    private lateinit var emailAddressListener: EmailAddressListener

    interface PhoneNumberListener{
        fun phoneNumberClick(position:Int)
    }

    interface EmailAddressListener{
        fun emailAddressClick(position:Int)
    }

    fun setOnItemClickListener(listener: PhoneNumberListener, listenerEmail: EmailAddressListener){
        phoneNumberListener=listener
        emailAddressListener=listenerEmail
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent, false)
        return ViewHolder(itemView,phoneNumberListener,emailAddressListener)
    }


    override fun onBindViewHolder(holder:ViewHolder, position: Int) {

        val currentItem= facultyList[position]
        holder.profilePicture.setImageResource(currentItem.profilePicture)
        holder.name.text=currentItem.name
        holder.phoneNumber.text=currentItem.phoneNumber
        holder.emailAddress.text=currentItem.emailAddress
    }


    override fun getItemCount(): Int {
        return facultyList.size
    }


    class ViewHolder(itemView: View,phoneNumberListener:PhoneNumberListener,emailAddressListener:EmailAddressListener):RecyclerView.ViewHolder(itemView){

        val profilePicture: ImageView= itemView.findViewById(R.id.profile_picture)
        val name:TextView= itemView.findViewById(R.id.name)
        val phoneNumber:TextView= itemView.findViewById(R.id.phone_number)
        val emailAddress:TextView= itemView.findViewById(R.id.email_address)

        init{
            phoneNumber.setOnClickListener {
                phoneNumberListener.phoneNumberClick(adapterPosition)
            }

            emailAddress.setOnClickListener {
                emailAddressListener.emailAddressClick(adapterPosition)
            }

        }

    }

}