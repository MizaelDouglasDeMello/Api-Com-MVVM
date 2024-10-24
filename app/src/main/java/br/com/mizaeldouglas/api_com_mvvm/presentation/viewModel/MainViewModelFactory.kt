package br.com.mizaeldouglas.api_com_mvvm.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.mizaeldouglas.api_com_mvvm.data.repository.IPostagemRepository
import br.com.mizaeldouglas.api_com_mvvm.data.repository.PostagemRepository
import br.com.mizaeldouglas.api_com_mvvm.domain.usecase.GetPostUseCase

class MainViewModelFactory(
    private val postUseCase: GetPostUseCase
) :  ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(postUseCase) as T
        }else{
            throw IllegalArgumentException("ViewModel não foi configurado corretaymente")
        }
    }
}