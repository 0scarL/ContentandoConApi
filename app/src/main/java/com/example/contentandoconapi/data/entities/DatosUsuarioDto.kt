package com.example.contentandoconapi.data.entities

import com.google.gson.annotations.SerializedName

data class DatosUsuarioDto(

    @SerializedName("nombre")
    var nombre : String,
    @SerializedName("tipoDocumento")
    var tipoDocumento: Integer,
    @SerializedName("documento")
    var documento: String,
    @SerializedName("movil")
    var movil : Integer,
    @SerializedName("correo")
    var correo : String,
    @SerializedName("fechaNacimiento")
    var fechaNacimiento: String ="",
    @SerializedName("contraseña")
    var contraseña: String


)
