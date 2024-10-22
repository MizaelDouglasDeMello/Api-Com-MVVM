package br.com.mizaeldouglas.api_com_mvvm.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mizaeldouglas.api_com_mvvm.data.model.Post
import br.com.mizaeldouglas.api_com_mvvm.data.repository.PostagemRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val postagemRepository: PostagemRepository
) : ViewModel() {

    var listaPostagens = MutableLiveData<List<Post>>()
        get() = postagemRepository.listaPostagensRepository

    fun recuperarPostagens() {

        viewModelScope.launch {
            postagemRepository.recuperarPostagem()
        }
    }
}