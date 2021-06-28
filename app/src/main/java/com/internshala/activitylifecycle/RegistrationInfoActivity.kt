package com.internshala.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class RegistrationInfoActivity : AppCompatActivity() {

    lateinit var txtInfoNameAdd: TextView
    lateinit var txtInfoMailAdd: TextView
    lateinit var txtInfoNumberAdd: TextView
    lateinit var txtInfoAddressAdd: TextView
    lateinit var txtInfoPwdAdd: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_info)

        title = "Registration Details"

        txtInfoNameAdd = findViewById(R.id.txtInfoNameAdd)
        txtInfoMailAdd = findViewById(R.id.txtInfoMailAdd)
        txtInfoNumberAdd = findViewById(R.id.txtInfoNumberAdd)
        txtInfoAddressAdd = findViewById(R.id.txtInfoAddressAdd)
        txtInfoPwdAdd = findViewById(R.id.txtInfoPwdAdd)

        if (intent != null) {
            val displayName = intent.getStringExtra("displayName")
            val displayMail = intent.getStringExtra("displayMail")
            val displayNumber = intent.getStringExtra("displayNumber")
            val displayAddress = intent.getStringExtra("displayAddress")
            val displayPwd = intent.getStringExtra("displayPwd")
            txtInfoNameAdd.text = displayName
            txtInfoMailAdd.text = displayMail
            txtInfoNumberAdd.text = displayNumber
            txtInfoAddressAdd.text = displayAddress
            txtInfoPwdAdd.text = displayPwd
        }

        var actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                intent = Intent(this@RegistrationInfoActivity, RegistrationActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}