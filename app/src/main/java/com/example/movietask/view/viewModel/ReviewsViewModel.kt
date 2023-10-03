package com.example.movietask.view.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movietask.data.model.ResponseReviews
import com.example.movietask.network.repository.ReviewRepository

class ReviewsViewModel : ViewModel() {

    var reviewRepo = ReviewRepository()
    var reviewData = MutableLiveData<ResponseReviews>()

//    fun getReviews(idMovie: Int, apiKey : String) : MutableLiveData<ResponseReviews>{
//        Log.d("API-REVIEWS", "onFailure: VM}")
//        reviewRepo.getReviews(apiKey = apiKey, movieId = idMovie){
//            reviewData.postValue(it)
//        }
//        return reviewData
//    }

}