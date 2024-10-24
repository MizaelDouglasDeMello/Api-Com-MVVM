package br.com.mizaeldouglas.api_com_mvvm.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.mizaeldouglas.api_com_mvvm.data.model.PostResponse
import br.com.mizaeldouglas.api_com_mvvm.domain.model.Post

interface IPostagemRepository {

    suspend fun recuperarPostagem() : List<Post>


}