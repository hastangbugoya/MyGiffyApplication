package com.example.mygiffyapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mygiffyapplication.databinding.ActivityMainBinding
import com.example.mygiffyapplication.utility.Logger.jLog
import com.example.mygiffyapplication.view.GiphyRecyclerViewAdapter
import com.example.mygiffyapplication.viewmodel.GiphyViewModel

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private var load_count = 15

    val loadSize = arrayOf<String>("15", "25", "35", "45")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myViewModel: GiphyViewModel by viewModels()

        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val myRecyclerView = binding.giphyRecycler
        val myAdapter = GiphyRecyclerViewAdapter()
        myRecyclerView.adapter = myAdapter

        binding.myCountSpinner.adapter = makeSpinnerAdapter()

        myViewModel.getAllTrends()
        myViewModel.trends.observe(this) {
            myAdapter.setData(it)
            binding.reload.visibility = getVisibility(myViewModel.getTrendCount())
            jLog("MainActivity loaded ${myViewModel.getTrendCount()} items")
        }

        binding.refreshButton.setOnClickListener {
            myViewModel.getAllTrends(load_count)
        }

        binding.myCountSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    load_count = Integer.parseInt(parent.getItemAtPosition(position).toString())
                    myViewModel.getAllTrends(load_count)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Do something when nothing is selected
                }
            }
    }

    fun makeSpinnerAdapter() =
        ArrayAdapter(this, android.R.layout.simple_spinner_item, loadSize).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

    fun getVisibility(count : Int) : Int {
        if (count == 0) return 8
        return 0
    }
}