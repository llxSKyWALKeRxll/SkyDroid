package com.internshala.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var titleName: String? = "SkyDroid"

    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnSignOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_hero_details)

        titleName = sharedPreferences.getString("Title", "#?@?@?#?")

        title = titleName

        btnSignOut = findViewById(R.id.btnSignOut)

        btnSignOut.setOnClickListener{
            sharedPreferences.edit().clear().apply()
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(
                this@MainActivity,
                "You have been successfully logged out!",
                Toast.LENGTH_SHORT
            ).show()
            this.finish()
        }
    }
}