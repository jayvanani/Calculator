package com.example.calculator2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import javax.security.auth.login.LoginException
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var ac: Button
    lateinit var plusminus: Button
    lateinit var percentage: Button
    lateinit var divide: Button
    lateinit var seven: Button
    lateinit var eight: Button
    lateinit var nine: Button
    lateinit var multiply: Button
    lateinit var four: Button
    lateinit var five: Button
    lateinit var six: Button
    lateinit var substraction: Button
    lateinit var one: Button
    lateinit var two: Button
    lateinit var three: Button
    lateinit var addition: Button
    lateinit var zero: Button
    lateinit var dot: Button
    lateinit var clear: Button
    lateinit var equals: Button
    lateinit var round:Button

    lateinit var textview: TextView

    var arrayList = ArrayList<Button>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ac = findViewById(R.id.ac)
        plusminus = findViewById(R.id.parenthesis)
        percentage = findViewById(R.id.percentage)
        divide = findViewById(R.id.divide)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        multiply = findViewById(R.id.multiply)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        substraction = findViewById(R.id.substraction)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        addition = findViewById(R.id.addition)
        zero = findViewById(R.id.zero)
        dot = findViewById(R.id.dot)
        clear = findViewById(R.id.clear)
        equals = findViewById(R.id.equals)
        round=findViewById(R.id.round)


        textview = findViewById(R.id.textview)

//      ac.setOnClickListener {
//
//          textview.setText("AC")
//      }
//        parenthesis.setOnClickListener {
//
//            textview.text="()"
//        }
//        percentage.setOnClickListener {
//
//            textview.text="%"
//        }
//
//        divide.setOnClickListener {
//
//            textview.text="/"
//        }
//        seven.setOnClickListener {
//            textview.text="7"
//        }
//        eight.setOnClickListener {
//            textview.text="8"
//        }
//        nine.setOnClickListener {
//            textview.text="9"
//        }
//        multiply.setOnClickListener {
//            textview.text="*"
//        }
//        four.setOnClickListener {
//            textview.text="4"
//        }
//        five.setOnClickListener {
//            textview.text="5"
//        }
//        six.setOnClickListener {
//            textview.text="6"
//        }
//        substraction.setOnClickListener {
//            textview.text="-"
//        }
//        one.setOnClickListener {
//            textview.text="1"
//        }
//        two.setOnClickListener {
//            textview.text="2"
//        }
//        three.setOnClickListener {
//            textview.text="3"
//        }
//        addition.setOnClickListener {
//            textview.text="+"
//        }
//        zero.setOnClickListener {
//            textview.text="0"
//        }
//        dot.setOnClickListener {
//            textview.text="."
//        }
//        equals.setOnClickListener{
//            textview.text="=."
//        }

        arrayList.add(0, zero)
        arrayList.add(1, one)
        arrayList.add(2, two)
        arrayList.add(3, three)
        arrayList.add(4, four)
        arrayList.add(5, five)
        arrayList.add(6, six)
        arrayList.add(7, seven)
        arrayList.add(8, eight)
        arrayList.add(9, nine)
        arrayList.add(10, addition)
        arrayList.add(11, multiply)
        arrayList.add(12, substraction)
        arrayList.add(13, divide)
        arrayList.add(14, equals)
        arrayList.add(15, dot)
        arrayList.add(16, ac)
        arrayList.add(17, percentage)
        arrayList.add(18, plusminus)
        arrayList.add(19, clear)
        arrayList.add(20,round)


        click(0, "0")
        click(1, "1")
        click(2, "2")
        click(3, "3")
        click(4, "4")
        click(5, "5")
        click(6, "6")
        click(7, "7")
        click(8, "8")
        click(9, "9")
        click(10, "+")
        click(11, "*")
        click(12, "-")
        click(13, "/")
        click(14, "=")
        click(15, ".")
        click(16, "AC")
        click(17, "%")
        click(18, "+/-")
        click(19, "X")
        click(20,"()")


    }


    var firstvalue = 0.0
    var secondvalue = 0.0
    var temp = 0.0
    var ans =0.0

    fun click(i: Int, s: String) {

        arrayList[i].setOnClickListener {

            if (s.equals("+")){
                procces(s)
            }
            else if(s.equals("-")){
                procces(s)
            }
            else if(s.equals("*")){
                procces(s)
            }
            else if(s.equals("/")){
                procces(s)
            }
            else if (s.equals("=")) {
                answer()

            }
            else if(s.equals("%"))
            {
                procces(s)

            }
            else if(s.equals("+/-"))
            {
                if(textview.text.startsWith("-"))
                {
                    textview.text=textview.text.substring(1,textview.text.length)
                }
                else
                {
                    textview.setText("-"+textview.text)
                }
            }
            else if(s.equals("X"))
            {
                textview.text=textview.text.substring(0,textview.text.length-1)
            }
            else if(s.equals("AC"))
            {
                textview.setText("")

                firstvalue=0.0
                secondvalue=0.0
                temp=0.0
                ans=0.0

                Sign.plus=false
                Sign.mul=false
                Sign.div=false
                Sign.minus=false
                Sign.modulo=false
            }
            else if(s.equals("0"))
            {
                if(!textview.text.startsWith("0") || textview.text.length>=2 )
                {
                    textview.text=textview.text.toString()+s
                }


            }
            else if(s.equals("."))
            {
                if(!textview.text.contains("."))
                {
                    if(textview.text.toString().isEmpty())
                    {
                        textview.text=textview.text.toString()+"0."
                    }
                    else
                    {
                        textview.text=textview.text.toString()+"."
                    }
                }

            }
            else if(s.equals("()"))
            {
                if(textview.text.toString().isEmpty())
                {
                    textview.text="("+textview.text.toString()
                }
                else if(!textview.text.toString().contains("("))
                {
                    textview.text=textview.text.toString()+"("
                }
                else if(textview.text.contains("("))
                {
                    textview.text=textview.text.toString()+")"
                }
                else
                {
                    textview.text=textview.text.toString()+"("
                }
            }
            else
            {
                textview.setText(textview.text.toString()+s)
            }

        }

    }


    private fun answer() {


        secondvalue = textview.text.toString().toDouble()


        Log.e("s","secondvalue:$secondvalue")

        if (Sign.plus) {
            ans = firstvalue + secondvalue
        }
        else if(Sign.minus){
            ans=firstvalue-secondvalue
        }
        else if(Sign.mul){
            ans=firstvalue*secondvalue
        }
        else if(Sign.div){
            ans=firstvalue/secondvalue
        }
        else if(Sign.modulo){
            ans=firstvalue*secondvalue/100
        }

        textview.setText(ans.toString())
        firstvalue=0.0
        secondvalue=0.0
        temp=0.0
        ans=0.0





    }

    private fun procces(s: String) {

        temp = textview.text.toString().toDouble()

        Log.e("======", "temp: $temp", )


        var f=1.0


        if (Sign.plus) {
            firstvalue = firstvalue + temp
        }
        else if(Sign.minus){
            firstvalue=firstvalue-temp

            Log.e("-","firstvalue:$firstvalue")
        }
        else if(Sign.mul){
            firstvalue=Math.max(1f,firstvalue.toFloat())*temp
        }
        else if(Sign.div){
            firstvalue=temp/f
        }
        else if(Sign.modulo){
            firstvalue=f*temp
        }
        else {
            firstvalue = temp
        }

        Sign.div=false
        Sign.mul=false
        Sign.minus=false
        Sign.plus=false
        Sign.modulo=false


        if (s.equals("+")) {

            Sign.plus = true
        }
        else if(s.equals("-")){

            Sign.minus=true
        }
        else if(s.equals("*")){
            Sign.mul=true
        }
        else if(s.equals("/")){
            Sign.div=true
        }
        else if(s.equals("%")){
            Sign.modulo=true
        }

        textview.setText("")

    }


}



class Sign {
    companion object {
        var plus = false
        var minus=false
        var div=false
        var mul=false
        var modulo=false
    }

}
