package com.example.mygiffyapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygiffyapplication.data.Data
import com.example.mygiffyapplication.network.MyRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import java.io.IOException

class GiphyViewModel : ViewModel() {
    var trends : MutableLiveData<List<Data>> = MutableLiveData<List<Data>>().apply { value = listOf() }

    fun getAllTrends() {
        viewModelScope.launch(Dispatchers.IO) {
            withTimeoutOrNull(30000) {
                try {
                    trends.postValue(
                        async {
                            MyRetrofit.getService().getTrends().body()?.data
                        }.await()
                    )
                } catch (e : IOException) {
                    Log.d ("Meow", e.toString())
                    trends.value = listOf()
                }
            }
        }
    }
    fun getTrendCount() : Int = trends.value?.size ?: 0
}