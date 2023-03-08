package com.example.mygiffyapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygiffyapplication.data.Data
import com.example.mygiffyapplication.network.MyRetrofit
import com.example.mygiffyapplication.utility.Logger.jLog
import kotlinx.coroutines.*
import java.io.IOException

class GiphyViewModel : ViewModel() {
    var trends: MutableLiveData<List<Data>> =
        MutableLiveData<List<Data>>().apply { value = listOf() }

    /*
    API only retrieves images rated G - even when tested from browser
    only the limit query field is functional
    */
    fun getAllTrends(limit: Int = 15) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                trends.postValue(
                    async {
                        MyRetrofit.getService().getTrends(limit = limit).body()?.data
                    }.await()
                )
            } catch (e: IOException) {
                jLog(e.toString())
                trends.value = listOf()
            }
        }
    }

    fun getTrendCount(): Int = trends.value?.size ?: 0
}

//    fun getAllTrends(limit: Int = 15) {
//        viewModelScope.launch(Dispatchers.Main) {
//            trends.value = withTimeoutOrNull(30000) {
//                try {
//                    withContext(Dispatchers.IO) {
//                        MyRetrofit.getService().getTrends(limit = limit).body()?.data
//                    }
//                } catch (e: IOException) {
//                    jLog(e.toString())
//                    listOf()
//                }
//            } ?: listOf<Data>().also {
//                jLog("Timed out")
//            }
//        }
//    }

//    trends.postValue(
//    try {
//        withTimeoutOrNull(40000) {
//            withContext(Dispatchers.IO) {
//                MyRetrofit.getService().getTrends(limit = limit).body()?.data ?: listOf<Data>().also {
//                    //API returned empty
//                }
//            }
//        }.let {
//            // Error timed out
//            listOf()
//        }
//    } catch (e: Exception) {
//        // Exception encountered
//        listOf<Data>()
//    }
//    )
//}