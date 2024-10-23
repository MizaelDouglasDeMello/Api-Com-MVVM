package br.com.mizaeldouglas.api_com_mvvm.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.mizaeldouglas.api_com_mvvm.data.model.Post

class PostagemBdRepository : IPostagemRepository {

    override val listaPostagensRepository = MutableLiveData<List<Post>>()

    override suspend fun recuperarPostagem() {
        val lista = listOf(
            Post(
                "Corpo", 1, "Banco de dados SQL - 1", 121
            ),
            Post(
                "Corpo", 2, "Banco de dados SQL - 2", 122
            ),
            Post(
                "Corpo", 3, "Banco de dados SQL - 3", 123
            ),
            Post(
                "Corpo", 4, "Banco de dados SQL - 4", 124
            ),
            )
        listaPostagensRepository.postValue(lista)
    }
}