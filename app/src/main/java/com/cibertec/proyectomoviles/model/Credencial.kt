package com.cibertec.proyectomoviles.model

import com.google.gson.annotations.SerializedName

data class Credencial(
    @SerializedName("correo")
    val correo : String?,
    @SerializedName("clave")
    val clave : String?
)
