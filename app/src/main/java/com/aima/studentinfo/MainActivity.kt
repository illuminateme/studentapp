package com.aima.studentinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aima.studentinfo.activity.AddStudentActivity
import com.aima.studentinfo.databinding.ActivityMainBinding
import com.aima.studentinfo.ui.ItemAdapter
import com.aima.studentinfo.ui.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }
        itemAdapter = ItemAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.itemRv.adapter = itemAdapter

        viewModel.getItems()
        viewModel.itemsLiveData.observe(this, { list ->
            itemAdapter.list = list
            itemAdapter.notifyDataSetChanged()
        })
    }
}