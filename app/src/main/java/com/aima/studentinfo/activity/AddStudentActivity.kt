package com.aima.studentinfo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.aima.studentinfo.databinding.ActivityAddStudentBinding
import com.aima.studentinfo.model.Student
import com.aima.studentinfo.ui.MainViewModel

class AddStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddStudentBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.AddBtn.setOnClickListener {
                addStudent()
            }

    }

    private fun addStudent() {
        val name = binding.InputName.editText?.text.toString()
        val seat = binding.InputSeat.editText?.text.toString()
        val classNames = binding.InputClass.editText?.text.toString()

        if (name.isNotEmpty() && seat.isNotEmpty() && classNames.isNotEmpty()) {
            val newSet = Student(name, seat, classNames)
            viewModel.addStudent(newSet)
            Toast.makeText(this, "Submitted", Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(this, "Fill in other fields before submitting", Toast.LENGTH_LONG).show()
        }
    }
}