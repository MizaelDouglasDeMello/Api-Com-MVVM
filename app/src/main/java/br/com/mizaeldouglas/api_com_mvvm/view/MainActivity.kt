package br.com.mizaeldouglas.api_com_mvvm.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import br.com.mizaeldouglas.api_com_mvvm.R
import br.com.mizaeldouglas.api_com_mvvm.databinding.ActivityMainBinding
import br.com.mizaeldouglas.api_com_mvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
     private val binding by lazy {
         ActivityMainBinding.inflate(layoutInflater)
     }
    private lateinit var mainViewModel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.listaPostagens.observe(this){listaPostagem ->
            var listaResultado = ""
            listaPostagem.forEach { postagem ->
                listaResultado += "${postagem.id} -- ${postagem.title} \n"
            }
            binding.txtResult.text = listaResultado
        }

    }

    override fun onStart() {
        super.onStart()
        mainViewModel.recuperarPostagens()

    }
}