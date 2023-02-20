package com.example.mygiffyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import com.example.mygiffyapplication.databinding.ActivityMainBinding
import com.example.mygiffyapplication.view.GiphyRecyclerViewAdapter
import com.example.mygiffyapplication.viewmodel.GiphyViewModel

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myViewModel : GiphyViewModel by viewModels()
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val myRecyclerView = binding.giphyRecycler
        val myAdapter = GiphyRecyclerViewAdapter()
        myRecyclerView.adapter = myAdapter
        Log.d("Meow", "Main Activity")
        myViewModel.getAllTrends()
        myViewModel.trends.observe(this){
            myAdapter.setData(it)
            if(myViewModel.getTrendCount() == 0) {
                binding.reload.visibility = View.VISIBLE
            } else {
                binding.reload.visibility = View.GONE
            }
            Log.d("Meow", "MainActivity count" + myViewModel.getTrendCount().toString())
        }
        binding.refreshButton.setOnClickListener {
            myViewModel.getAllTrends()
        }

    }
}