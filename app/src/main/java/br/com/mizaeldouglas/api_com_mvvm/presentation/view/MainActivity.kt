package br.com.mizaeldouglas.api_com_mvvm.presentation.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import br.com.mizaeldouglas.api_com_mvvm.R
import br.com.mizaeldouglas.api_com_mvvm.data.api.RetrofitService
import br.com.mizaeldouglas.api_com_mvvm.data.repository.PostagemBdRepository
import br.com.mizaeldouglas.api_com_mvvm.data.repository.PostagemRepository
import br.com.mizaeldouglas.api_com_mvvm.databinding.ActivityMainBinding
import br.com.mizaeldouglas.api_com_mvvm.domain.usecase.GetPostUseCase
import br.com.mizaeldouglas.api_com_mvvm.presentation.viewModel.MainViewModel
import br.com.mizaeldouglas.api_com_mvvm.presentation.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val jsonPlaceApi = RetrofitService.getJsonPlace()
        val postagemRepository = PostagemRepository(jsonPlaceApi)
        val postUseCase = GetPostUseCase(postagemRepository)


        /*    --------------- Utilizando Outros Bancos de Dados ---------------      */
//        val postagemRepository = PostagemBdRepository()
//        val postagemRepository = PostagensFirebaseRepository()



        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(postUseCase))[MainViewModel::class.java]
//        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.listaPostagens.observe(this) { listaPostagem ->
            var listaResultado = ""
            listaPostagem.forEach { postagem ->
                listaResultado += "${postagem.id} - ${postagem.titulo} \n"
            }
            binding.txtResult.text = listaResultado
        }

    }

    override fun onStart() {
        super.onStart()
        mainViewModel.recuperarPostagens()

    }
}