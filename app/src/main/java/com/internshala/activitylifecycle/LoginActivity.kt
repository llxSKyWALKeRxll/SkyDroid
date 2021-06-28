package com.internshala.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var tvNumber: EditText
    lateinit var tvPwd: EditText
    lateinit var btnLogIN: Button
    lateinit var tvForgotPwd: TextView
    lateinit var tvRegistration: TextView

    lateinit var sharedPreferences: SharedPreferences

    val validMobileNumber = "1234"
    val validPwd = arrayOf("surya", "karn", "bhishma", "arjuna", "abhimanyu", "krishna")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_login)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if(isLoggedIn) {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "SkyDroid: Log In"

        tvNumber = findViewById(R.id.etNumber)
        tvPwd = findViewById(R.id.etPwd)
        btnLogIN = findViewById(R.id.btnLogIn)
        tvForgotPwd = findViewById(R.id.tvForgotPwd)
        tvRegistration = findViewById(R.id.tvRegistration)

        btnLogIN.setOnClickListener {
            val mobileNumber = tvNumber.text.toString()
            val pwd = tvPwd.text.toString()
            val intent = Intent(this@LoginActivity, MainActivity::class.java)

            var toolBarName = "SkyDroid"

            if (mobileNumber == validMobileNumber && validPwd.contains(pwd)) {
                when (pwd) {
                    validPwd[0] -> {
                        toolBarName = "Welcome, Surya Dev"
                        savePreferencesTrue(toolBarName)
                        startActivity(intent)
                        Toast.makeText(
                            this@LoginActivity,
                            "You have been successfully logged in!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    validPwd[1] -> {
                        toolBarName = "Welcome, Daanveer Karn"
                        savePreferencesTrue(toolBarName)
                        startActivity(intent)
                        Toast.makeText(
                            this@LoginActivity,
                            "You have been successfully logged in!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    validPwd[2] -> {
                        toolBarName = "Welcome, Bhishma Pitamah"
                        savePreferencesTrue(toolBarName)
                        startActivity(intent)
                        Toast.makeText(
                            this@LoginActivity,
                            "You have been successfully logged in!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    validPwd[3] -> {
                        toolBarName = "Welcome, Arjuna"
                        savePreferencesTrue(toolBarName)
                        startActivity(intent)
                        Toast.makeText(
                            this@LoginActivity,
                            "You have been successfully logged in!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    validPwd[4] -> {
                        toolBarName = "Welcome, Abhimanyu"
                        savePreferencesTrue(toolBarName)
                        startActivity(intent)
                        Toast.makeText(
                            this@LoginActivity,
                            "You have been successfully logged in!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    validPwd[5] -> {
                        toolBarName = "Welcome, Krishna"
                        savePreferencesTrue(toolBarName)
                        startActivity(intent)
                        Toast.makeText(
                            this@LoginActivity,
                            "You have been successfully logged in!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else {
                Toast.makeText(
                    this@LoginActivity,
                    "Invalid credentials!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        tvRegistration.setOnClickListener{
            val intent = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(intent)
        }

        tvForgotPwd.setOnClickListener{
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferencesTrue(title: String) {
        sharedPreferences.edit().putString("Title", title).apply()
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
    }
}