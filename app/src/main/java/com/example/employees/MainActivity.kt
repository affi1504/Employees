package com.example.employees

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employees.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),EmployeeAdapter.onItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var employeeList: ArrayList<Employee>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        employeeList = generateList()
        binding.recyclerView.adapter = EmployeeAdapter(employeeList,this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding. recyclerView.setHasFixedSize(true)

    }

    override fun onItemCLick(position: Int) {
        Toast.makeText(this,"item $position clicked",Toast.LENGTH_SHORT).show()
        val intent = Intent(this, EmployeeDetailActivity::class.java)
        intent.putExtra("image",employeeList[position].imageResource)
        intent.putExtra("name",employeeList[position].name)
        intent.putExtra("designation",employeeList[position].designation)
        intent.putExtra("mobile",employeeList[position].mobile)
        intent.putExtra("address",employeeList[position].address)
        startActivity(intent)


    }


    private fun generateList():ArrayList<Employee>{
        val list = ArrayList<Employee>()
        list.add(Employee(R.mipmap.user1_round,"CHIN YEN","LAB ASSISTANT","+917676543234","1 MAIN AVE, WA, TACOCA, USA"))
        list.add(Employee(R.mipmap.user2_round,"MIKE PEARL","SENIOR ACCOUNTANT","+917865799803","B BLOCK NICE STREET, WENEN, TACOCA,SCODD"))
        list.add(Employee(R.mipmap.user3_round,"GREEN SALLY","ACCOUNTANT","+917990546743","UNIVERSAL NEW AVE, BOURNNILE, BRISDON, NEW START"))
        list.add(Employee(R.mipmap.user4_round,"DEWANE PAUL","PROGRAMMER","+916657980909","SPACE, 1 OF 1, ANDALUSIAN, PARALLEL, NEW RIVER"))
        list.add(Employee(R.mipmap.user5_round,"MATTS","QUALITY ANALYST","+917760878943","WOODOO, COMMONS, UNITED KINGDOM"))
        list.add(Employee(R.mipmap.user7_round,"PLANK OTO","ACCOUNTANT","+918790456732","TUCSON, AZ MSA, ALPINE, ARIZONA, USA"))
        return list
    }


}