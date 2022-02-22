package com.neznaika_77.firebase_povtorenie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.neznaika_77.firebase_povtorenie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signup.setOnClickListener{
            val phone = binding.phone.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            database = FirebaseDatabase
                .getInstance("https://fir-povtorenie-default-rtdb.firebaseio.com/").reference.child("TEST_KEY")

                    val user = User(phone, email, password)

            database.child(password).setValue(user).addOnSuccessListener {
                binding.phone.text.clear()
                binding.email.text.clear()
                binding.password.text.clear()
            }.addOnFailureListener { print("Error") }
        }
    }
}