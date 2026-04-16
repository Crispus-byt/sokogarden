package com.crispus.chuisokogarden

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.loopj.android.http.RequestParams

class Payments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payments)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val productname=intent.getStringExtra("product_name")
        val productdescription=intent.getStringExtra("product_description")
        val productcost=intent.getStringExtra("product_cost")
        val productphoto=intent.getStringExtra("product_photo")


        val name=findViewById<TextView>(R.id.product_name)
        val description=findViewById<TextView>(R.id.product_description)
        val cost=findViewById<TextView>(R.id.product_cost)
        val photo=findViewById<ImageView>(R.id.product_photo)
        val phone=findViewById<EditText>(R.id.phone)
        val checkout=findViewById<Button>(R.id.purchase)


        name.text=productname
        cost.text="ksh $productcost"
        description.text=productdescription

        Glide.with(this)
            .load(productphoto)
            .circleCrop()
            .into(photo)






        checkout.setOnClickListener {

            val api="http://crispus.alwaysdata.net/api/mpesa_payment"

            val data= RequestParams()

            data.put("amount",productcost)
            data.put("phone",phone.text.toString())

            val helper= ApiHelper(applicationContext)
            helper.post(api,data)


        }








    }
}