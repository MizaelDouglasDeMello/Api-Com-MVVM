package br.com.mizaeldouglas.api_com_mvvm.data.model

import br.com.mizaeldouglas.api_com_mvvm.domain.model.Post

data class PostResponse(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

fun PostResponse.toPost(): Post{
    return Post(
        descricao = this.body,
        titulo = this.title,
        id = this.id,
        idUsuario = this.userId
    )
}