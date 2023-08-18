package com.cibertec.proyectomoviles.model

import com.google.gson.annotations.SerializedName

data class Reserva(
    @SerializedName("id")
    val id : Int,
    @SerializedName("idRestaurante")
    val idRestaurante: Int,
    @SerializedName("nombres")
    val nombres : String,
    @SerializedName("direccion")
    val direccion : String,
    @SerializedName("cantidad")
    val cantidad: Int,
    @SerializedName("fecha")
    val fecha : String,
    @SerializedName("hora")
    val hora :String?
)
