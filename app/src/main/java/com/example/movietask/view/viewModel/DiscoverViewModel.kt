package com.example.movietask.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movietask.data.model.ResponseDiscoverMovie
import com.example.movietask.network.repository.DiscoverMovieRepository

class DiscoverViewModel : ViewModel() {

    var discoverRepo = DiscoverMovieRepository()
    var discoverData = MutableLiveData<ResponseDiscoverMovie>()

    fun getDiscover(apiKey : String, genreId : Int? = null) : MutableLiveData<ResponseDiscoverMovie>{
        discoverRepo.getDiscoverMovie(apiKey = apiKey, genreId = genreId){
            discoverData.postValue(it)
        }
        return discoverData
    }


}