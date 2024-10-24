package br.com.mizaeldouglas.api_com_mvvm.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.mizaeldouglas.api_com_mvvm.data.model.PostResponse

//class PostagensFirebaseRepository() : IPostagemRepository {
//    override val listaPostagensRepository = MutableLiveData<List<PostResponse>>()
//    override suspend fun recuperarPostagem() {
//        val lista = listOf(
//            PostResponse(
//                "Corpo", 1, "FireBase - 1", 120
//            ),
//            PostResponse(
//                "Corpo", 2, "FireBase - 2", 122
//            ),
//            PostResponse(
//                "Corpo", 3, "FireBase - 3", 123
//            ),
//            PostResponse(
//                "Corpo", 4, "FireBase - 4", 124
//            ),
//        )
//        listaPostagensRepository.postValue(lista)
//    }
//
//
//}