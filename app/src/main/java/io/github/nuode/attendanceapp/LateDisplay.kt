package io.github.nuode.attendanceapp

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.view.View

import kotlinx.android.synthetic.main.activity_late_display.*
import java.util.*

class LateDisplay : AppCompatActivity() {
    companion object {
        const val Late_String = "Oops, something went wrong..."
        const val date = "my birthday"
        const val Big_List = "Data.."
        const val name_List = "Names.."
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_late_display)
        myfunction()
    }
    private fun myfunction() {
        var longtext = ""
        val mystring = intent.getStringExtra(Late_String)

        val myarray = intent.getStringArrayExtra(Big_List)
        val names = intent.getStringArrayExtra(name_List)

        val date = intent.getStringExtra(date)

        titleView.text = getString(R.string.latedisplaytitle, date)
        if (mystring == "") {
            lateView.text = getString(R.string.latecomerstring, "None")
        } else {
            lateView.text = getString(R.string.latecomerstring, mystring)
        }

        for (i in 0 until names.size) {
            longtext += names[i] + " : " + myarray[i] + "\n"
        }
        contentView.text = longtext
    }

    fun saveData(view: View) {
        val newIntent = Intent(this, MainActivity::class.java)
        startActivity(newIntent)
    }
}

