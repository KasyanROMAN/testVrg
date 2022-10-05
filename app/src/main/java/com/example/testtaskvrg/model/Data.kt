package com.example.testtaskvrg.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("modhash")
    val modhash: String,
    @SerializedName("after")
    val after: String,
    @SerializedName("before")
    val before: String
)

