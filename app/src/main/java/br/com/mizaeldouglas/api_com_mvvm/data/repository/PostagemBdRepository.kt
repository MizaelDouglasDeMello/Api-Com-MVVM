package br.com.mizaeldouglas.api_com_mvvm.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.mizaeldouglas.api_com_mvvm.data.model.PostResponse

//class PostagemBdRepository : IPostagemRepository {
//
//    override val listaPostagensRepository = MutableLiveData<List<PostResponse>>()
//
//    override suspend fun recuperarPostagem() {
//        val lista = listOf(
//            PostResponse(
//                "Corpo", 1, "Banco de dados SQL - 1", 121
//            ),
//            PostResponse(
//                "Corpo", 2, "Banco de dados SQL - 2", 122
//            ),
//            PostResponse(
//                "Corpo", 3, "Banco de dados SQL - 3", 123
//            ),
//            PostResponse(
//                "Corpo", 4, "Banco de dados SQL - 4", 124
//            ),
//            )
//        listaPostagensRepository.postValue(lista)
//    }
//}