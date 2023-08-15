package com.cibertec.proyectomoviles.data

import com.cibertec.proyectomoviles.model.Credencial
import com.cibertec.proyectomoviles.model.Restaurante
import com.cibertec.proyectomoviles.model.Result
import com.cibertec.proyectomoviles.model.Usuario
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

object Api {
    private val retrofit : Retrofit.Builder = Retrofit.Builder()
        .baseUrl("http://alfredo94-001-site1.atempurl.com/")
        .addConverterFactory(GsonConverterFactory.create())

    interface MyServices{
        @POST("kotlin/Usuario/CrearUsuario")
        suspend fun saveUser(@Body request: Usuario) : Response<Result>

        @POST("kotlin/Usuario/ObtenerUsuario")
        suspend fun searchUser(@Path("correo") correo: Credencial, @Path("clave") clave:String) : Response<Result>

        @POST("kotlin/Restaurante/CrearRestaurante")
        suspend fun saveRestaurant(@Body request:Restaurante):Response<Result>

        @GET("kotlin/Listado/ListarRestaurante")
        suspend fun getAllRestaurant(): Response<List<Restaurante>>

        @GET("kotlin/Obtener/BuscarRestaurantePorId")
        suspend fun getRestaurant(@Query("id")id:Int):Response<Restaurante>
    }

    fun build() : MyServices{
        return retrofit.build().create(MyServices::class.java)
    }
}