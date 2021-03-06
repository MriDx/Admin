package com.example.admin.Network

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.admin.Network.DataClasses.*
import retrofit2.http.*

interface ApiClient {

    @GET("home")
    suspend fun getHome(): Response<ApiData>
    @GET("orders/{page}")
    suspend fun getOrders(@Path("page") page: Int): Response<Orders>



}

object ApiAdapter {
    val apiClient: ApiClient = Retrofit.Builder()
        .baseUrl("http://aiishop.in/admin/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()
        .create(ApiClient::class.java)
}
