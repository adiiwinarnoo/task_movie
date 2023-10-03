package com.example.movietask.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movietask.data.model.ResponseGenreMovies
import com.example.movietask.network.repository.GenreRepository

class GenreViewModel : ViewModel() {

    var genreRepo = GenreRepository()
    var dataGenre = MutableLiveData<ResponseGenreMovies>()

//    fun getGenreViewModel(apiKey : String) : MutableLiveData<ResponseGenreMovies>{
//        genreRepo.getGenreMovies(apiKey){
//            dataGenre.postValue(it)
//        }
//        return dataGenre
//    }

}