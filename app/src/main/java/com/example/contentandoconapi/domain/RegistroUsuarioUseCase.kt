package com.example.contentandoconapi.domain

import com.example.contentandoconapi.data.entities.DatosUsuarioDto
import com.example.contentandoconapi.data.entities.RespuestaLogin
import com.example.contentandoconapi.data.respository.RegistroRepository
import javax.inject.Inject

class RegistroUsuarioUseCase @Inject constructor(
    private val registroRepository: RegistroRepository,
) {
    suspend operator fun invoke(datosUsuarioDto: DatosUsuarioDto): RespuestaLogin {
        return registroRepository.registrarUsuario(datosUsuarioDto)
    }
}