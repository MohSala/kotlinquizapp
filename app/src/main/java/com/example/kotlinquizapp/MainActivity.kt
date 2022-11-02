package com.example.kotlinquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var answerCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rg = findViewById<RadioGroup>(R.id.rg)
        val visible = findViewById<CheckBox>(R.id.visible)
        val invisible = findViewById<CheckBox>(R.id.invisible)
        val none = findViewById<CheckBox>(R.id.none)

        rg.setOnCheckedChangeListener { _, checkedId ->
            val clicked = rg.findViewById(checkedId) as RadioButton
            val checked = clicked.isChecked
            if(checked && clicked.text.toString() == "AVD Manager"){
                answerCount++
            }

        }
        visible.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                answerCount++

        };
        invisible.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                answerCount++

        };
        none.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                answerCount++

        };


    }

    fun submit(view: View){
           val cal = Calendar.getInstance()
           val t = SimpleDateFormat("HH:mm").format(cal.time)
        var builder = AlertDialog.Builder(this)
         builder.setIcon(R.drawable.ic_launcher_background)
        builder.setTitle("Congratulations!")
        builder.setMessage("You submitted on $t and achieved ${answerCount * 25}%")
        builder.setPositiveButton("DONE"){ dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun reset(view: View) {
        val visible = findViewById<CheckBox>(R.id.visible)
        val invisible = findViewById<CheckBox>(R.id.invisible)
        val none = findViewById<CheckBox>(R.id.none)
        val rg = findViewById<RadioGroup>(R.id.rg)
         visible.isChecked = false
        invisible.isChecked = false
        none.isChecked = false
        val checked = rg.checkedRadioButtonId
        val clicked = rg.findViewById(checked) as RadioButton
        clicked.isChecked = false

    }

}