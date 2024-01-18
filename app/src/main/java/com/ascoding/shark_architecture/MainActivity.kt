package com.ascoding.shark_architecture

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baseUrlTest: String = BuildConfig.BASE_URL
       // val baseUrlProd: String = BuildConfig.BASE_URL_PROD

        Toast.makeText(this , baseUrlTest, Toast.LENGTH_SHORT).show()

    }
}