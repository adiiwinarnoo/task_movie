package com.example.movietask.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movietask.data.model.ResponseMoviesVideos
import com.example.movietask.network.repository.VideosRepository

class VideosViewModel : ViewModel() {

    val videosRepo = VideosRepository()
    var videoData = MutableLiveData<ResponseMoviesVideos>()

//    fun getMovies(apiKey : String, movieId : Int):MutableLiveData<ResponseMoviesVideos>{
//        videosRepo.getVideos(apiKey,movieId){
//            videoData.postValue(it)
//        }
//        return videoData
//    }

}