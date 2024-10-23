package br.com.mizaeldouglas.api_com_mvvm.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.mizaeldouglas.api_com_mvvm.data.model.Post

interface IPostagemRepository {

    val listaPostagensRepository: MutableLiveData<List<Post>>
    suspend fun recuperarPostagem()


}