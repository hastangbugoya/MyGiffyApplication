package com.example.mygiffyapplication.view

import androidx.recyclerview.widget.DiffUtil
import com.example.mygiffyapplication.data.Data

class MyDiffUtil(private val oldList: List<Data>, private val newList: List<Data>) : DiffUtil.Callback(){

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}