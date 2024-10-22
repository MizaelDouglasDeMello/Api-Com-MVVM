package br.com.mizaeldouglas.api_com_mvvm.data.api

import br.com.mizaeldouglas.api_com_mvvm.data.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceApi {

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}