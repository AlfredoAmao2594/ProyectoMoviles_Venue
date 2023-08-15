package com.cibertec.proyectomoviles.model

import com.google.gson.annotations.SerializedName

data class Respuesta(
    @SerializedName("codigoMensaje")
    val codigoMensaje:Int,
    @SerializedName("resultadoMensaje")
    val resultadoMensaje:String

)
