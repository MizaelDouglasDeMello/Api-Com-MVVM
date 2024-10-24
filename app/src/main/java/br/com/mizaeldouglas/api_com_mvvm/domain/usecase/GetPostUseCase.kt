package br.com.mizaeldouglas.api_com_mvvm.domain.usecase

import br.com.mizaeldouglas.api_com_mvvm.data.repository.IPostagemRepository
import br.com.mizaeldouglas.api_com_mvvm.domain.model.Post

class GetPostUseCase(
    private val repository: IPostagemRepository
) {
    suspend fun recuperarPostagem(): List<Post> {
        try {
            return repository.recuperarPostagem()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return emptyList()
    }
}