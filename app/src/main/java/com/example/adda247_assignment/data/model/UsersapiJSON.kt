package com.example.adda247_assignment.data.model


import com.example.adda247_assignment.data.model.Data
import com.example.adda247_assignment.data.model.Meta
import com.google.gson.annotations.SerializedName

data class UsersapiJSON(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("meta")
    val meta: Meta
)