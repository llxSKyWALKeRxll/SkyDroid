package com.internshala.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var txtForgotPwdNumber: EditText
    lateinit var txtForgotPwdMail: EditText
    lateinit var btnForgotSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        title = "Forgot Password"

        txtForgotPwdNumber = findViewById(R.id.txtForgotPwdNumber)
        txtForgotPwdMail = findViewById(R.id.txtForgotPwdMail)
        btnForgotSubmit = findViewById(R.id.btnForgotSubmit)

        var actionbar = getSupportActionBar()
        if(actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
        }

        btnForgotSubmit.setOnClickListener {
            val displayPwdNumber = txtForgotPwdNumber.text.toString()
            val displayPwdMail = txtForgotPwdMail.text.toString()
            intent = Intent(this@ForgotPasswordActivity, ForgotPasswordDetailsActivity::class.java)
            intent.putExtra("NumberInfo", displayPwdNumber)
            intent.putExtra("MailInfo", displayPwdMail)
            startActivity(intent)
            Toast.makeText(
                this@ForgotPasswordActivity,
                "This app is still in its development phase. This feature shall be available shortly!",
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                intent = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}