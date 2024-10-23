package br.com.mizaeldouglas.api_com_mvvm.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.mizaeldouglas.api_com_mvvm.data.repository.IPostagemRepository
import br.com.mizaeldouglas.api_com_mvvm.data.repository.PostagemRepository

class MainViewModelFactory(
    private val repository: IPostagemRepository
) :  ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(repository) as T
        }else{
            throw IllegalArgumentException("ViewModel não foi configurado corretaymente")
        }
    }
}