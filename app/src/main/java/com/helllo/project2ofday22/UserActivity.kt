package com.helllo.project2ofday22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        //Yha mai "User" ka data "String" ke form me le rha hu "intent" se joki mai "MainActivity" me bnaya hu,
        //Or "intent" ko lene ke liye as a "string" hame "getStringExtra" ka use karna hota h
        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phone")

        //yeh "int" value le rha h isiliye maine "getIntExtra" use kiya h
        //Agar "imageId" nahi dikhe to "pic5" dikha dena
        val imageId = intent.getIntExtra("imageId", R.drawable.pic5)


        val nameTv = findViewById<TextView>(R.id.tVName)
        val phoneTv = findViewById<TextView>(R.id.tVPhone)
        val image = findViewById<CircleImageView>(R.id.profile_image)

        nameTv.text = name
        phoneTv.text = phoneNumber
        image.setImageResource(imageId)

    }
}