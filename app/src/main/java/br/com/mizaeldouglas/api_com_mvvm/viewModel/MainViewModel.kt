package br.com.mizaeldouglas.api_com_mvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mizaeldouglas.api_com_mvvm.model.Post
import br.com.mizaeldouglas.api_com_mvvm.model.PostApi
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val listaPostagens = MutableLiveData<List<Post>>()

    fun recuperarPostagens(){

        val postApi = PostApi()

        viewModelScope.launch {
            val postagens = postApi.recuperarPostagem()
            listaPostagens.postValue(postagens)
        }
    }
}