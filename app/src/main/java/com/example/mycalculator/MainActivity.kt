package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

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
    fun equal(view: View){
        if(Lastnumber){
             var tvValue=tv?.text.toString()
            var prefix=""
            try {
                if(tvValue.startsWith("-")){
                     prefix = "-"
                    tvValue=tvValue.substring(1)
                }
                if (tvValue.contains("-")){
                    var splitValue=tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty()){
                        one= prefix + one
                    }
                    tv?.text= removezero((one.toDouble()-two.toDouble()).toString())
                }
                else  if (tvValue.contains("+")){
                    var splitValue=tvValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty()){
                        one= prefix + one
                    }
                    tv?.text= removezero((one.toDouble()+two.toDouble()).toString())
                }
                else  if (tvValue.contains("*")){
                    var splitValue=tvValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty()){
                        one= prefix + one
                    }
                    tv?.text= removezero((one.toDouble()*two.toDouble()).toString())
                }
                else  if (tvValue.contains("/")){
                    var splitValue=tvValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(prefix.isNotEmpty()){
                        one= prefix + one
                    }
                    tv?.text= removezero((one.toDouble()/two.toDouble()).toString())
                }


            }
            catch (e:ArithmeticException){
                e.printStackTrace()

            }
        }
    }
    fun removezero(result: String):String{
        var value=result
        if(result.contains(".0")){
            value=result.substring(0,result.length-2)
        }
        return value
    }
    fun operator(view: View){
        if (Lastnumber && !operateadded(tv?.text.toString())){
            tv?.append((view as Button).text)
        }
        Lastnumber=false
        Lastdot=false

    }
    fun operateadded(value: String):Boolean{
      return if (value.startsWith("-")){
                 false
      }
        else
      {
          value.contains("+")
                  ||value.contains("-")
                  ||value.contains("*")
                  ||value.contains("/")
      }
    }
}