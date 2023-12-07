package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var tv:TextView?=null
    var Lastnumber:Boolean=false
    var Lastdot:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv=findViewById(R.id.tv)
    }
    fun digit(view: View){
       // Toast.makeText(this,"Button is just clicked",Toast.LENGTH_SHORT).show()
        tv?.append((view as Button).text)
        Lastdot=false
        Lastnumber=true
    }
    fun clr(view: View){
        tv?.text=""
    }
    fun dot(view: View){
      if (Lastnumber && !Lastdot){
         tv?.append(".")
         Lastnumber=false
         Lastdot=true
      }
    }
}