package br.com.mizaeldouglas.api_com_mvvm.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.mizaeldouglas.api_com_mvvm.data.api.JsonPlaceApi
import br.com.mizaeldouglas.api_com_mvvm.data.model.PostResponse
import br.com.mizaeldouglas.api_com_mvvm.data.model.toPost
import br.com.mizaeldouglas.api_com_mvvm.domain.model.Post

class PostagemRepository (
    private val jsonPlaceApi: JsonPlaceApi
): IPostagemRepository {
//    override val listaPostagensRepository = MutableLiveData<List<PostResponse>>()

    override suspend fun recuperarPostagem() : List<Post> {
        try {
            val response = jsonPlaceApi.getPosts()
            if (response.isSuccessful && response.body() != null) {
                val listaPostagemResponse = response.body()
                val listaPostagem = listaPostagemResponse?.map { postResponse ->
                    postResponse.toPost()
                }
                if (listaPostagem != null){
                    return listaPostagem
                }
//                listaPostagensRepository.postValue(response.body())
            }
        } catch (e: Exception) {
            Log.i("getPosts", "getPosts: ${e.message}")
        }

        return emptyList()
    }
}
