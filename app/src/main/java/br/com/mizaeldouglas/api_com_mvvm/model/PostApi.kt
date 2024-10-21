package br.com.mizaeldouglas.api_com_mvvm.model

import android.util.Log
import br.com.mizaeldouglas.api_com_mvvm.api.RetrofitService

class PostApi {

    suspend fun recuperarPostagem(): List<Post> {
        val jsonPlace = RetrofitService.getJsonPlace()

        try {
            val response = jsonPlace.getPosts()
            if (response.isSuccessful) {
                response.body()?.let { post ->
                    return post
                }
            }
        } catch (e: Exception) {
            Log.i("getPosts", "getPosts: ${e.message}")
        }

        return  emptyList()
    }
}
