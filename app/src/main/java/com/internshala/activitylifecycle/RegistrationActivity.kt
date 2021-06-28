package com.internshala.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {

    lateinit var btnRegistration: Button
    lateinit var etxtRegName: EditText
    lateinit var etxtRegMail: EditText
    lateinit var etxtRegNumber: EditText
    lateinit var etxtRegAddress: EditText
    lateinit var etxtRegPwd: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        title = "Register Yourself"

        etxtRegName = findViewById(R.id.etxtRegName)
        etxtRegMail = findViewById(R.id.etxtRegMail)
        etxtRegNumber = findViewById(R.id.etxtRegNumber)
        etxtRegAddress = findViewById(R.id.etxtRegAddress)
        etxtRegPwd = findViewById(R.id.etxtRegPwd)

        btnRegistration = findViewById(R.id.btnRegistration)

        btnRegistration.setOnClickListener{
            val regName = etxtRegName.text.toString()
            val regMail = etxtRegMail.text.toString()
            val regNumber = etxtRegNumber.text.toString()
            val regAddress = etxtRegAddress.text.toString()
            val regPwd = etxtRegPwd.text.toString()
            intent = Intent(this@RegistrationActivity, RegistrationInfoActivity::class.java)
            intent.putExtra("displayName", regName)
            intent.putExtra("displayMail", regMail)
            intent.putExtra("displayNumber", regNumber)
            intent.putExtra("displayAddress", regAddress)
            intent.putExtra("displayPwd", regPwd)
            startActivity(intent)
            Toast.makeText(
                this@RegistrationActivity,
                "This app is still in its development phase. This feature shall be available shortly!",
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }

        var actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}