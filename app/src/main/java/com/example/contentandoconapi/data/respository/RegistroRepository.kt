package com.example.contentandoconapi.data.respository

import com.example.contentandoconapi.data.entities.DatosUsuarioDto
import com.example.contentandoconapi.data.entities.RespuestaLogin
import com.example.contentandoconapi.data.network.ServicioRegistroUser
import javax.inject.Inject

class RegistroRepository @Inject constructor(
    private val servicioRegistroUser: ServicioRegistroUser,
) {
    suspend fun registrarUsuario(datosUsuarioDto: DatosUsuarioDto): RespuestaLogin {
        return servicioRegistroUser.resgistrarUser(datosUsuarioDto)
    }

}