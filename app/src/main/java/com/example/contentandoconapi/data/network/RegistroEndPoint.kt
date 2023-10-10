package com.example.contentandoconapi.data.network

import com.example.contentandoconapi.data.entities.DatosUsuarioDto
import com.example.contentandoconapi.data.entities.RespuestaLogin
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistroEndPoint {

    @POST("usuario/registrar")
    suspend fun registroUsuario(@Body datosUsuarioDto: DatosUsuarioDto) : RespuestaLogin

}