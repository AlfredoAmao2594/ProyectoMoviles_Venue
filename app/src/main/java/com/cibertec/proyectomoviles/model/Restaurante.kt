package com.cibertec.proyectomoviles.model

import com.google.gson.annotations.SerializedName

data class Restaurante(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imagen")
    val imagen:String,
    @SerializedName("nombreRestaurante")
    val nombreRestaurante:String,
    @SerializedName("categoria")
    val categoria:String,
    @SerializedName("descripcion")
    val descripcion:String,
    @SerializedName("direccion")
    val direccion:String,
    @SerializedName("horaInicio")
    val horaInicio:String,
    @SerializedName("horaFin")
    val horaFin:String
)

