package com.example.adda247_assignment.data.repository

import com.example.adda247_assignment.data.model.UsersapiJSON
import retrofit2.http.GET

interface APIrequest {
    @GET("/public-api/users")
   suspend fun getUsers(): UsersapiJSON
}