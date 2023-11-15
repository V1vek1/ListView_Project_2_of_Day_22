package com.helllo.project2ofday22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    //Yha maine ek "lateinit" ke help se "ArrayList" bnaya jisme hum "User Class" ke details ko pass karenge baad me
    lateinit var userArrayList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Yha maine "Array" bnaya jisme "string" ke trough "users" ke data pass ho rhe h
        val name = arrayOf("Saumya", "Aman", "Ankit", "Kriti", "Sonam")
        val lastMsg = arrayOf("Hey everyone", "I am fine", "Good", "Awesome", "cool")
        val lastMsgTime = arrayOf("6:25 AM", "7:30 PM", "5:00 PM", "6:25 AM", "7:30 PM")
        val phoneNumber = arrayOf("786453739", "986453739", "7366382829", "7383413440", "4159251517")


        //Yha bhi maine ek "IntArray" bnaya h jisme sabhi "Users" ke "pic" pass ho rhe h by the Help of "Index"
        val imgId = intArrayOf(R.drawable.pic5, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4)
        userArrayList = ArrayList()


        //Yha mai "for Loop" ki help se sabhi "users" per "Traverse" kiya,Taki One by One sabhi "Users"
        //ka (name , lastMsg, lastMsgTime, phoneNumber, imgId) yeh sab mil jaye
        for(eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phoneNumber[eachIndex],
                imgId[eachIndex])

            userArrayList.add(user)  //Yah maine Users ko ArrayList me Add kar diya
        }





        //Yha maine "listView" ko liya xml se
        val listView = findViewById<ListView>(R.id.listView)

        listView.isClickable = true  //phir "listView" ko btaya ki tum Clickable ho

        //yha maine khud ka Adapter bnaya or usme Sabhi "Users" ka data Dediya
        listView.adapter = MyAdapter(this, userArrayList)


        //Yha mai yeh bta rha hu ki, "listView" per Click karne per Yeh sab details ko "new Activity" per dikhao
        listView.setOnItemClickListener { parent, view, position, id ->
            // open a new activity

            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgId[position]

            val i = Intent(this, UserActivity::class.java)  //Yha mai new Activity ko "intent" me assign kiya

            //PutExtra "intent" ka ek uses h
            //"putExtra" ki Help se hum, User ke iss data ko "UserActivity" me dikha rhe h
            i.putExtra("name", userName)
            i.putExtra("phone", userPhone)
            i.putExtra("imageId", imageId)
            startActivity(i)
        }

    }
}