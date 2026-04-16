package com.crispus.chuisokogarden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signin=findViewById<TextView>(R.id.signin_link)

        signin.setOnClickListener {
            val signinIntent= Intent(applicationContext, Signin::class.java)

            startActivity(signinIntent)
        }

        val username=findViewById<EditText>(R.id.username)
        val email=findViewById<EditText>(R.id.email)
        val phone=findViewById<EditText>(R.id.phone)
        val password=findViewById<EditText>(R.id.password)
        val signupbutton=findViewById<Button>(R.id.signupbutton)



        signupbutton.setOnClickListener{

            val api="http://bridgit.alwaysdata.net/api/signup"



            val data= RequestParams()

            data.put("email",email.text.toString())
            data.put("password",password.text.toString().trim())
            data.put("phone",phone.text.toString())
            data.put("username",username.text.toString())





            val helper= ApiHelper(applicationContext)
            helper.post_login(api,data)


        }


    }
}