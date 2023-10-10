package com.example.contentandoconapi.utils

import com.example.contentandoconapi.data.network.RegistroEndPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitCaller {
    
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://quicklypay.azurewebsites.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val servicio = getRetrofit().create(RegistroEndPoint::class.java)
}