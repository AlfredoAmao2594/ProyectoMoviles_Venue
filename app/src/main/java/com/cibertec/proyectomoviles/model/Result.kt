package com.cibertec.proyectomoviles.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("tipoError")
    val tipoError:Int,
    @SerializedName("mensaje")
    val mensaje:String,
    @SerializedName("retorno")
    val retorno:String
)
