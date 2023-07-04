 package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginregister.databinding.ActivitySecondBinding
import com.google.firebase.auth.FirebaseAuth

 class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var user: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        user = FirebaseAuth.getInstance()

        if (user.currentUser != null) {
            user.currentUser?.let{

                binding.tvUserEmail.text = it.email
            }
        }

        binding.btnSignOut.setOnClickListener {
            user.signOut()
            startActivity(
                intent(
                    this,
                    MainActivity::class.java
                )
            )
            finish()
        }
    }

     private fun intent(secondActivity: SecondActivity, java: Class<MainActivity>): Intent? {
         TODO("Not yet implemented")
     }

 }