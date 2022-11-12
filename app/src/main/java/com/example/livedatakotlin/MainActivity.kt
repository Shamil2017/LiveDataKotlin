package com.example.livedatakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

class MainActivity : AppCompatActivity() {


    var count = 0
    private  lateinit var  viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val textView = findViewById<TextView>(R.id.number_txt)
        val button = findViewById<Button>(R.id.buttonStart)

        //textView.text = count.toString()
        //textView.text = viewModel.count.toString()
        viewModel.count.observe(this, Observer {
            textView.text = it.toString()
        })
        button.setOnClickListener {
            //++count
            viewModel.updateCount()
            //textView.text = viewModel.count.toString()
        }



    }
}