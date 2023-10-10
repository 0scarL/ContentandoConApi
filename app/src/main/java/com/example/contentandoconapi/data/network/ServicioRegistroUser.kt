package com.example.contentandoconapi.data.network

import com.example.contentandoconapi.utils.RetrofitCaller
import com.example.contentandoconapi.data.entities.DatosUsuarioDto
import com.example.contentandoconapi.data.entities.RespuestaLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ServicioRegistroUser @Inject constructor() {

 suspend fun resgistrarUser(datosUsuarioDto: DatosUsuarioDto) : RespuestaLogin{
    return withContext(Dispatchers.IO){
        val respuesta = RetrofitCaller.servicio.registroUsuario(datosUsuarioDto)
        respuesta
    }
 }
}