package com.example.mygiffyapplication.view

import android.opengl.Visibility
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mygiffyapplication.R
import com.example.mygiffyapplication.data.Data
import com.example.mygiffyapplication.databinding.DataItemBinding
import java.text.SimpleDateFormat
import java.time.LocalDate

class GiphyRecyclerViewAdapter : RecyclerView.Adapter<GiphyRecyclerViewAdapter.GiphyViewHolder>() {
    var dataList = listOf<Data>()

    inner class GiphyViewHolder(binding: DataItemBinding ) : RecyclerView.ViewHolder(binding.root) {
        var binding : DataItemBinding = binding
    }

    override fun onBindViewHolder(holder: GiphyViewHolder, position: Int) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        holder.binding.apply {
            trendHeader.text = dataList.get(position).title
            username.text = dataList.get(position).username.also {
                if (it.isNullOrBlank()) username.visibility = View.GONE
                else username.visibility = View.VISIBLE
            }
            Glide.with(holder.binding.root)
                .applyDefaultRequestOptions(RequestOptions.fitCenterTransform())
                .load(dataList.get(position).images?.fixedHeight?.url)
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.baseline_error_outline_24).into(mainImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiphyViewHolder {
        val binding = DataItemBinding.inflate(LayoutInflater.from(parent.context), parent,   false)
        return GiphyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    public fun setData (l : List<Data>) {
        dataList = l
        notifyDataSetChanged()
    }
}