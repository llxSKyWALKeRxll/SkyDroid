package com.internshala.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ForgotPasswordDetailsActivity : AppCompatActivity() {

    lateinit var txtPhnzzDet: TextView
    lateinit var txtEmzzDet: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password_details)

        title = "Info Details"

        var actionbar = getSupportActionBar()

        txtPhnzzDet = findViewById(R.id.txtPhnzzDet)
        txtEmzzDet = findViewById(R.id.txtEmzzDet)

        if(intent != null) {
            val displayPhnzz = intent.getStringExtra("NumberInfo")
            val displayEmzz = intent.getStringExtra("MailInfo")
            txtPhnzzDet.text = displayPhnzz
            txtEmzzDet.text = displayEmzz
        }

        if(actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                intent = Intent(this@ForgotPasswordDetailsActivity, ForgotPasswordActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}