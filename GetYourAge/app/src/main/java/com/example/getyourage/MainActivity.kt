package com.example.getyourage

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val button: Button = findViewById(R.id.btnDatePicker)
//        button.setOnClickListener {
//            Toast.makeText(this, "Button Works" , Toast.LENGTH_LONG).show()
//        }

        btnDatePicker.setOnClickListener {view->
            setDate(view)
            //Toast.makeText(this, "Button Works" , Toast.LENGTH_LONG).show()
        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun setDate(view:View){

        val rightNow = Calendar.getInstance()
        val year = rightNow.get(Calendar.YEAR)
        val month = rightNow.get(Calendar.MONTH)
        val day = rightNow.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this , DatePickerDialog.OnDateSetListener {
                view, selectedYear, selectedMonth, selectedDayOfMonth ->
            Toast.makeText(this, "Calender Works" , Toast.LENGTH_LONG).show()
            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                SelectedDate.setText(selectedDate)
            val sdf = SimpleDateFormat("dd/MM/yyyy" , Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)

            val SelectedDateInMin = theDate!!.time/60000
            val  currDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currdateinMins = currDate!!.time/60000
            val diff = currdateinMins - SelectedDateInMin
            SelectedDateInMinutes.setText(diff.toString())

        },year,month,day).show()

    }
}


