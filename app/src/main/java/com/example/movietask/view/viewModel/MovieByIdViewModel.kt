package com.example.movietask.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movietask.data.model.ResponseMovieById
import com.example.movietask.network.repository.MovieByIdRepository

class MovieByIdViewModel : ViewModel() {

    var repoMovieById = MovieByIdRepository()
    var dataMovieById = MutableLiveData<ResponseMovieById>()

    fun getMovieById(idMovie : Int, apiKey : String): MutableLiveData<ResponseMovieById>{
        repoMovieById.getMovieById(idMovie,apiKey){
            dataMovieById.postValue(it)
        }
        return dataMovieById
    }

}