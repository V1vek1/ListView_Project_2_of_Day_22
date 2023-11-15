package com.helllo.project2ofday22

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.helllo.project2ofday22.R
import com.helllo.project2ofday22.User
import de.hdodenhof.circleimageview.CircleImageView


//Adapter :- Adapter ek jariya h, jiski help se hum Layout/LIstView/Recycle View ko App se Link karte h

//Maine Yha ek Class bnya h jiska name h "MyAdapter"
//Yha maine Khud ka Adapter to bnaya hi h, per hum chate h ki hum ByDefault wale Adapter Function ka sara
//Functionality kok use kare, To issiliye hamne ":" lagane ke baad "ArrayAdapter" function ko use kiya

class MyAdapter (private val context : Activity, private val arrayList: ArrayList<User>) :
    ArrayAdapter<User>(context, R.layout.eachritem, arrayList) {


    //Yha maine Ek Override Function bnaya with "GetView", GetView "eachItem" ke sabhi "view" le rha h
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //Yha maine "inFlater" bnakar "eachItem" ka view le liya
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.eachritem, null)

        //Or iss "EachItem" me jobhi "View" the or uss "views" me bhi h hum uska Address leiye
        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.tVName)
        val lastMsg = view.findViewById<TextView>(R.id.tVLastMessage)
        val lastMsgTime = view.findViewById<TextView>(R.id.tVLastMsgTime)

        //Yha mai sabhi "users" ka pura details get kar rha hu or unke "position" per de rha hu, position yani Index
        name.text = arrayList[position].name
        lastMsg.text = arrayList[position].lastMsg
        lastMsgTime.text = arrayList[position].lastMsgTime
        image.setImageResource(arrayList[position].imageId)

        return view  //Yha maine "View" ko return kar diya
    }
}