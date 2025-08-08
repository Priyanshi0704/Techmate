package com.example.techmate.activities

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.techmate.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signup : AppCompatActivity() {
    lateinit var database : DatabaseReference //it is a data type like float , int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val nameEt = findViewById<TextInputEditText>(R.id.nameEditText)
        val emailEt = findViewById<TextInputEditText>(R.id.emailEditText)
        val passwordEt = findViewById<TextInputEditText>(R.id.passwordEditText)
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        //user input like we take in c++
        signUpButton.setOnClickListener {
            val name = nameEt.text.toString()
            val email = emailEt.text.toString()
            val password = passwordEt.text.toString()
            //create an object of the class
            val user = Users(name,email,password)

            //getInstance is used to create a new object and getReference is used to point to the existing object or class

            database = FirebaseDatabase.getInstance().getReference("Users")

            //let's take the child now as name and we'll change in future as child is something unique from where we can access the full info of the user
            database.child(name).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }


        }


    }
}