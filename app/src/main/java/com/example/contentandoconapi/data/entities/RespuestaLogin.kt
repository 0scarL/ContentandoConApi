package com.example.contentandoconapi.data.entities

import com.google.gson.annotations.SerializedName

data class RespuestaLogin(
    @SerializedName("exitoso")
    val exitoso :Boolean
)
