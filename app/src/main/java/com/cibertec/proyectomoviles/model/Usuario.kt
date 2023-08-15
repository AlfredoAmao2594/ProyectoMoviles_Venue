package com.cibertec.proyectomoviles.model

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("nombreApellido")
    val names : String?,
    @SerializedName("correo")
    val correo : String?,
    @SerializedName("clave")
    val clave : String?,
    @SerializedName("pais")
    val pais : String?,
    @SerializedName("celular")
    val celular : String?,
    @SerializedName("primer_gusto")
    val primer_gusto : String?,
    @SerializedName("segundo_gusto")
    val segundo_gusto : String?,
    @SerializedName("tercer_gusto")
    val tercer_gusto : String?,
    @SerializedName("cuarto_gusto")
    val cuarto_gusto : String?,
    @SerializedName("quinto_gusto")
    val quinto_gusto : String?


)
