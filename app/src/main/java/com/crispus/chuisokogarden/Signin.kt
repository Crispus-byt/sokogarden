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

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signin=findViewById<TextView>(R.id.signup_link)

        signin.setOnClickListener {

            val signinIntent= Intent(applicationContext, Signup::class.java)

            startActivity(signinIntent)
        }

        val email=findViewById<EditText>(R.id.email)
        val password=findViewById<EditText>(R.id.password)
        val signinbutton=findViewById<Button>(R.id.signinbutton)

//        http://crispus.alwaysdata.net/api/signup
//    http://crispus.alwaysdata.net/api/getproductdetails
//    http://crispus.alwaysdata.net/api/signin
//    http://crispus.alwaysdata.net/api/mpesa_payment


        signinbutton.setOnClickListener {

            val api="http://crispus.alwaysdata.net/api/signin"

//            request params is a container usde to collect the user details its like form data in js

            val data= RequestParams()

            data.put("email",email.text.toString())
            data.put("password",password.text.toString().trim())




            val helper= ApiHelper(applicationContext)
            helper.post_login(api,data)



        }
    }
}