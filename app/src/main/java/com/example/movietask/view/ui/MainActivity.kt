package com.example.movietask.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movietask.R
import com.example.movietask.data.model.ResponseGenreMovies
import com.example.movietask.databinding.ActivityMainBinding
import com.example.movietask.view.viewModel.GenreViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private var dataGenreModel = mutableListOf<String?>()
    lateinit var genreViewModel : GenreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var apiKey = "a38ad1d2fd9237645392de32122554eb"

        genreViewModel = ViewModelProvider(this)[GenreViewModel::class.java]
        getGenre(apiKey)

        genreViewModel.dataGenre.observe(this) {
            it?.genres?.forEach {
                dataGenreModel.add(it?.name ?: "")
            }
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataGenreModel)
            binding.spinnerGenre.adapter = adapter
        }


    }

    private fun getGenre(apiKey : String){
        genreViewModel.getGenreViewModel(apiKey)
    }
}