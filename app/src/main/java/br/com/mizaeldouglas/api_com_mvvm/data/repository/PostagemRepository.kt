package br.com.mizaeldouglas.api_com_mvvm.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.mizaeldouglas.api_com_mvvm.data.api.JsonPlaceApi
import br.com.mizaeldouglas.api_com_mvvm.data.model.Post

class PostagemRepository (
    private val jsonPlaceApi: JsonPlaceApi
): IPostagemRepository {
    override val listaPostagensRepository = MutableLiveData<List<Post>>()

    override suspend fun recuperarPostagem() {
        try {
            val response = jsonPlaceApi.getPosts()
            if (response.isSuccessful && response.body() != null) {
                listaPostagensRepository.postValue(response.body())
            }
        } catch (e: Exception) {
            Log.i("getPosts", "getPosts: ${e.message}")
        }
    }
}
