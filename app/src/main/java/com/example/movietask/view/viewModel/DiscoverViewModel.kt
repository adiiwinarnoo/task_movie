package com.example.movietask.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietask.data.model.ResponseDiscoverMovie
import com.example.movietask.network.repository.DiscoverMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val discoverRepo: DiscoverMovieRepository) : ViewModel() {
    var dataDiscover = MutableLiveData<Response<ResponseDiscoverMovie>>()
    var dataDiscoverCoroutines = MutableLiveData<Response<ResponseDiscoverMovie>>()

    fun getDiscover(apiKey: String, genreId: Int? = null) {
        discoverRepo.getDiscoverMovie(apiKey, genreId).observeForever {
            dataDiscover.postValue(it)
        }
    }

    fun getDiscoverUsingCoroutines(apiKey: String,genreId: Int? = null ){
        viewModelScope.launch {
            val response = discoverRepo.getDisMovie(apiKey,genreId)
            dataDiscoverCoroutines.postValue(response)
        }
    }
}