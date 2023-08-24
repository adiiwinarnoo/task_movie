package com.example.movietask.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movietask.R
import com.example.movietask.data.model.ResponseGenreMovies
import com.example.movietask.databinding.ActivityMainBinding
import com.example.movietask.utils.Constant
import com.example.movietask.view.adapter.DiscoverAdapter
import com.example.movietask.view.viewModel.DiscoverViewModel
import com.example.movietask.view.viewModel.GenreViewModel
import com.example.movietask.view.viewModel.VideosViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private var dataGenreModel = mutableListOf<String?>()
    lateinit var genreViewModel : GenreViewModel
    lateinit var genreNames : List<String>
    lateinit var discoverViewModel : DiscoverViewModel
    lateinit var discoverAdapter : DiscoverAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var apiKey = "a38ad1d2fd9237645392de32122554eb"

        genreViewModel = ViewModelProvider(this)[GenreViewModel::class.java]
        discoverViewModel = ViewModelProvider(this)[DiscoverViewModel::class.java]
        getGenre(apiKey)

        val genreMap = hashMapOf<String, Int>()
        binding.spinnerGenre.setSelection(0)
        getDiscover(apiKey)
        binding.recyclerView.layoutManager = GridLayoutManager(this,2)

        genreViewModel.dataGenre.observe(this) {
            it?.genres?.forEach { genre ->
                genre?.name?.let { name ->
                    genre.id?.let { id ->
                        genreMap[name] = id
                    }
                }
                genreNames = mutableListOf("Pilih Genre") + it.genres.mapNotNull { it?.name } ?: emptyList()
                val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genreNames)
                binding.spinnerGenre.adapter = adapter
            }
        }
        discoverViewModel.discoverData.observe(this){
            discoverAdapter = DiscoverAdapter(it.results!!)
            binding.recyclerView.adapter = discoverAdapter

            discoverAdapter.setItemClickListener(object : DiscoverAdapter.ItemClickListener{
                override fun onClick(view: View, position: Int, idMovie: Int) {
                    val intent = Intent(this@MainActivity,MovieDetailActivity::class.java)
                    intent.putExtra(Constant.ID_MOVIE,idMovie)
                    startActivity(intent)
                }
            })
        }

        binding.spinnerGenre.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val selectedGenreName = genreNames[p2]
                val selectedGenreId = genreMap[selectedGenreName]
                getDiscover(apiKey = apiKey, genreId = selectedGenreId)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

    }

    private fun getGenre(apiKey : String){
        genreViewModel.getGenreViewModel(apiKey)
    }

    private fun getDiscover(apiKey: String,genreId : Int? = null){
        discoverViewModel.getDiscover(apiKey = apiKey, genreId = genreId)
    }
}