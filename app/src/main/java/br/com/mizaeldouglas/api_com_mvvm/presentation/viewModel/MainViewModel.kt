package br.com.mizaeldouglas.api_com_mvvm.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mizaeldouglas.api_com_mvvm.data.repository.IPostagemRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: IPostagemRepository
) : ViewModel() {

    val listaPostagens
        get() = repository.listaPostagensRepository

    fun recuperarPostagens() {
        viewModelScope.launch {
            repository.recuperarPostagem()
        }
    }
}