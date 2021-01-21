package com.example.employees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.employees.databinding.ActivityEmployeeDetailBinding
import com.example.employees.databinding.ActivityMainBinding

class EmployeeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmployeeDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeeDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var intent = intent
        val image: Int = intent.getIntExtra("image", R.drawable.ic_android)
        val name = intent.getStringExtra("name")
        val designation = intent.getStringExtra("designation")
        val mobile = intent.getStringExtra("mobile")
        val address = intent.getStringExtra("address")

        binding.detailImage.setImageResource(image)
        binding.name.text = name
        binding.designation.text = designation
        binding.mobile.text = mobile
        binding.addess.text = address

    }
}

