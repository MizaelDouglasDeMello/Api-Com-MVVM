package br.com.mizaeldouglas.api_com_mvvm.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mizaeldouglas.api_com_mvvm.data.repository.IPostagemRepository
import br.com.mizaeldouglas.api_com_mvvm.domain.model.Post
import br.com.mizaeldouglas.api_com_mvvm.domain.usecase.GetPostUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val postUseCase: GetPostUseCase
) : ViewModel() {

    val listaPostagens = MutableLiveData<List<Post>>()
//        get() = repository.listaPostagensRepository

    fun recuperarPostagens() {
        viewModelScope.launch {
            val postagens = postUseCase.recuperarPostagem()
            listaPostagens.postValue(postagens)
        }
    }
}