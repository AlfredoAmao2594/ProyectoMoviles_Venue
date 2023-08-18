package com.cibertec.proyectomoviles.model

import com.google.gson.annotations.SerializedName

data class reservaHecha(
    @SerializedName("id")
    val id : Int,
    @SerializedName("imagen")
    val imagen: String,
    @SerializedName("nombreRestaurante")
    val nombreRestaurante : String,
    @SerializedName("categoria")
    val categoria : String,
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("hora")
    val hora : String
)
