package com.example.mygiffyapplication.network

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class MyRetrofitAPITest {

@Test
fun TestAPI() {

    runBlocking {
        val response = MyRetrofit.getService().getTrends()
        assertNotNull(response.body())
        assertTrue(response.isSuccessful)
        assertEquals(200, response.code())
    }
}
}