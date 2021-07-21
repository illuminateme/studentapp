package com.aima.studentinfo.Api

import com.aima.studentinfo.model.Items
import com.aima.studentinfo.model.Student
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PlaceHolderAPI {

    @GET("items")
    suspend fun getItems(): List<Items>

    @POST("students")
    suspend fun addStudents(@Body newSet: Student): List<Student>
}