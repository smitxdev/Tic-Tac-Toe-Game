package com.appydesk.tictactoegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    var flag = 0
    var Count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    //Onclick Attribute on Button
    fun check(view: View) {
        val btnCurrent = view as Button





        if (btnCurrent.text == "") {
            Count++ //this increament count value when button pressed

            if (flag == 0) {
                btnCurrent.text = "X"
                flag =1
            }else{
                btnCurrent.text = "O"
                flag = 0
            }
            //When Count will be greater then 4 then only conditions will be checked
            if (Count>4){
                when {
                    checkCond(btn1,btn2,btn3) -> {
                       showMsg(btn1.getStr())
                        h1.visibility = View.VISIBLE
                        restartGame()

                    }
                    checkCond(btn4,btn5,btn6) ->{
                        showMsg(btn4.getStr())
                        h2.visibility = View.VISIBLE
                        restartGame()
                    }
                    checkCond(btn7,btn8,btn9)->{
                        showMsg(btn7.getStr())
                        h3.visibility = View.VISIBLE
                        restartGame()
                    }
                    checkCond(btn1,btn4,btn7)->{
                        showMsg(btn1.getStr())
                        v1.visibility = View.VISIBLE
                        restartGame()
                    }
                    checkCond(btn2,btn5,btn8)->{
                        showMsg(btn2.getStr())
                        v2.visibility = View.VISIBLE
                        restartGame()
                    }
                    checkCond(btn3,btn6,btn9)->{
                        showMsg(btn3.getStr())
                        v3.visibility = View.VISIBLE
                        restartGame()
                    }
                    checkCond(btn1,btn5,btn9)->{
                        showMsg(btn1.getStr())
                        lDiag.visibility = View.VISIBLE
                        restartGame()
                    }
                    checkCond(btn3,btn5,btn7)->{
                        showMsg(btn3.getStr())
                        rDaig.visibility = View.VISIBLE
                        restartGame()
                    }
                    Count ==9 ->{
                        Toast.makeText(this,"Match is drawn!",Toast.LENGTH_LONG).show()
                        restartGame()
                    }



                }
            }
        }
    }


//Inline function
private fun Button.getStr() = this.text.toString()

    //Using Scope Function
                                      //Return Value Boolean
val checkCond: (Button,Button,Button)->Boolean = {a,b,c ->
        a.getStr()==b.getStr()&&b.getStr()==c.getStr()&&c.getStr()!=""}


val showMsg: (String)->Unit = {msg ->
    Toast.makeText(this,"Winner Is $msg",Toast.LENGTH_LONG).show()
}



    private fun restartGame(){
        Handler().postDelayed({

            btn1.text =""
            btn2.text =""
            btn3.text =""
            btn4.text =""
            btn5.text =""
            btn6.text =""
            btn7.text =""
            btn8.text =""
            btn9.text =""

            flag = 0
            Count = 0

            //Setting imageview visiblity gone in restart
            h1.visibility = View.GONE
            h2.visibility= View.GONE
            h3.visibility= View.GONE

            v1.visibility= View.GONE
            v2.visibility= View.GONE
            v3.visibility= View.GONE

            lDiag.visibility= View.GONE
            rDaig.visibility= View.GONE


            //doSomethingHere()
        }, 2500)









    }
}
