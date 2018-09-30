package io.github.nuode.attendanceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
//import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.textView1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun newEntryView(view: View) {
        val randomIntent = Intent(this, SecondActivity::class.java)
        randomIntent.putExtra(SecondActivity.Refresh, "yes")
        startActivity(randomIntent)
    }

    fun Olddata(view: View) {
        // Get the text view
        // Get the value of the text view.
        //val countString = textView1.text.toString()

        // Convert value to a number and increment it
        //var count: Int = Integer.parseInt(countString)
        //count += 1

        // Display the new value in the text view.
        //textView1.text = count.toString();
    }
}