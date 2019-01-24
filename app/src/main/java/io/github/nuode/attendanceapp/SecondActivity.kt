package io.github.nuode.attendanceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import android.view.View


import kotlinx.android.synthetic.main.activity_second.*
import java.text.SimpleDateFormat
import java.util.*




val namearray = arrayOf("Alphonsus","Lucas", "Nuode", "Conrad","Isaac","Jaden","Jireh","Kylle","Alastor","Jing Hao","Ryan Lim", "Yuan Heng", "Choo Ray", "Daniel Mok", "Derrick","Rafael","Riaz","Guang Xiang","Jit Yoei","Yunrui","Dominic","Zach","Donny","Justinian","Tze Shaun")
var count = 0
var datalist = Array(namearray.size, {"Unknown"})

class SecondActivity : AppCompatActivity() {

    companion object {
        const val Refresh = "lol"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val refreshstring = intent.getStringExtra(Refresh)
        if (refreshstring == "yes") {
            count = 0
            datalist = Array(namearray.size, {"Unknown"})
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        if (count != namearray.size) {
            name_label.text = namearray.elementAt(count)
        }
        button.visibility = View.VISIBLE
        button2.visibility = View.VISIBLE
        back_button.visibility = View.GONE
        if (count > 0) {
            back_button.visibility = View.VISIBLE
        }
        if (count == namearray.size) {
            button.visibility = View.GONE
            button2.visibility = View.GONE
            completebtn.visibility = View.VISIBLE
        }
    }

    fun PPresent(view: View) {
        if (count < namearray.size) {
            datalist[count] = "Present"
            count += 1
            if (count != namearray.size) {
                name_label.text = namearray.elementAt(count)
            }
            back_button.visibility = View.VISIBLE
        }
        if (count == namearray.size) {
            button.visibility = View.GONE
            button2.visibility = View.GONE
            completebtn.visibility = View.VISIBLE
        }
    }
    fun PAbsent(view: View) {
        if (count < namearray.size) {
            datalist[count] = "Absent"
            count += 1
            if (count != namearray.size) {
                name_label.text = namearray.elementAt(count)
            }
            back_button.visibility = View.VISIBLE
        }
        if (count == namearray.size) {
            button.visibility = View.GONE
            button2.visibility = View.GONE
            completebtn.visibility = View.VISIBLE
        }
    }
    fun backPressed(view: View) {
        if (count > 0) {
            count -= 1
            name_label.text = namearray.elementAt(count)
            button.visibility = View.VISIBLE
            button2.visibility = View.VISIBLE
            completebtn.visibility = View.GONE
            if (count == 0) {
                back_button.visibility = View.GONE
            }
        }
    }
    fun finalised(view: View) {
        var latestring = ""
        var finallatestring = ""
        for (i in 0 until namearray.size) {
            if (datalist[i] == "Absent") {
                latestring += namearray[i] + ", "
            }
        }
        if (latestring.length != 0) {
            finallatestring = latestring.substring(0,latestring.length-2)
        } else {
            finallatestring = latestring
        }

        val displayIntent = Intent(this, LateDisplay::class.java)

        val c = Calendar.getInstance().time
        val df = SimpleDateFormat("dd-MMM-yyyy",Locale.getDefault())
        val date = df.format(c).toString()


        displayIntent.putExtra(LateDisplay.Late_String, finallatestring)
        displayIntent.putExtra(LateDisplay.Big_List, datalist)
        displayIntent.putExtra(LateDisplay.name_List, namearray)
        displayIntent.putExtra(LateDisplay.date, date)
        startActivity(displayIntent)
    }
}
