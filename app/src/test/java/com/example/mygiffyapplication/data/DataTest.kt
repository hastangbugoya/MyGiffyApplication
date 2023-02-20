package com.example.mygiffyapplication.data

import org.junit.Assert.*
import org.junit.Test

class DataTest {

    @Test
    fun testDefaultConstructor() {
        val data = Data()
        assertNotNull(data.images) // instantiated as default value
        with(data) {
            assertEquals("", rating)
            assertEquals("", title)
            assertEquals("", trendingDatetime)
            assertEquals("", username)
        }
    }

    @Test
    fun testParameterizedConstructor() {
        val images = Images()
        val data = Data(
            images = images,
            rating = "G",
            trendingDatetime = "2022-02-20 12:00:00",
            title = "title",
            username = "username"
        )
        with(data) {
            assertEquals(images, images)
            assertEquals("G", rating)
            assertEquals("title", title)
            assertEquals("2022-02-20 12:00:00", trendingDatetime)
            assertEquals("username", username)
        }
    }


    @Test
    fun testGettersAndSetters() {
        val data = Data(
            rating = "rating",
            trendingDatetime = "trending_datetime",
            username = "username"
        )
        with(data) {
            assertEquals("rating", rating)
            assertEquals("trending_datetime", trendingDatetime)
            assertEquals("username", username)
        }

        data.images = null
        data.rating = null
        data.trendingDatetime = null
        data.username = null

        with(data) {
            assertEquals(null, images)
            assertEquals(null, trendingDatetime)
            assertEquals(null, username)
        }
    }

    @Test
    fun testEquals() {
        val data1 = Data(
            title = "title"
        )
        val data2 = Data(
            title = "title"
        )
        val data3 = Data(
            title = "title"
        )
        assertEquals(data1, data2)
        assertNotEquals(data1, data3)
    }
}
