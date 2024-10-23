package br.com.mizaeldouglas.api_com_mvvm.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.mizaeldouglas.api_com_mvvm.data.model.Post

class PostagensFirebaseRepository() : IPostagemRepository {
    override val listaPostagensRepository = MutableLiveData<List<Post>>()
    override suspend fun recuperarPostagem() {
        val lista = listOf(
            Post(
                "Corpo", 1, "FireBase - 1", 120
            ),
            Post(
                "Corpo", 2, "FireBase - 2", 122
            ),
            Post(
                "Corpo", 3, "FireBase - 3", 123
            ),
            Post(
                "Corpo", 4, "FireBase - 4", 124
            ),
        )
        listaPostagensRepository.postValue(lista)
    }


}