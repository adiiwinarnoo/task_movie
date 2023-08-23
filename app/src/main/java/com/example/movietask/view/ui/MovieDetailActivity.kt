package com.example.movietask.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movietask.databinding.ActivityMovieDetailBinding
import com.example.movietask.utils.Constant
import com.example.movietask.view.adapter.ReviewsAdapter
import com.example.movietask.view.viewModel.MovieByIdViewModel
import com.example.movietask.view.viewModel.ReviewsViewModel

class MovieDetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityMovieDetailBinding
    lateinit var viewModelMovieDetail : MovieByIdViewModel
    lateinit var reviewsViewModel : ReviewsViewModel
    var apiKey = "a38ad1d2fd9237645392de32122554eb"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelMovieDetail = ViewModelProvider(this)[MovieByIdViewModel::class.java]
        reviewsViewModel = ViewModelProvider(this)[ReviewsViewModel::class.java]
        binding.recyclerReviews.layoutManager = LinearLayoutManager(this)

        var idMovie = intent.getIntExtra(Constant.ID_MOVIE,0)

        getMovieById(idMovie = idMovie, apiKey = apiKey)
        getReviews(idMovie = idMovie, apiKey = apiKey)

        viewModelMovieDetail.dataMovieById.observe(this){
            Glide.with(this).load("https://image.tmdb.org/t/p/w500" + it.posterPath).into(binding.imgThumbnail)
            binding.tvTitle.text = it.title
            binding.tvDescription.text = it.overview
            binding.tvRating.text = it.voteAverage.toString()
        }

        reviewsViewModel.reviewData.observe(this){
            var adapter = ReviewsAdapter(it.results!!)
            binding.recyclerReviews.adapter = adapter
        }


    }

    private fun getMovieById(idMovie : Int, apiKey : String){
        viewModelMovieDetail.getMovieById(idMovie,apiKey)
    }
    private fun getReviews(idMovie: Int, apiKey : String){
        reviewsViewModel.getReviews(idMovie, apiKey)
    }
}