package com.example.movietask.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movietask.databinding.ActivityMovieDetailBinding
import com.example.movietask.utils.Constant
import com.example.movietask.view.adapter.ReviewsAdapter
import com.example.movietask.view.viewModel.MovieByIdViewModel
import com.example.movietask.view.viewModel.ReviewsViewModel
import com.example.movietask.view.viewModel.VideosViewModel

class MovieDetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityMovieDetailBinding
    lateinit var viewModelMovieDetail : MovieByIdViewModel
    lateinit var reviewsViewModel : ReviewsViewModel
    var apiKey = "a38ad1d2fd9237645392de32122554eb"
    lateinit var videosViewModel : VideosViewModel
    private lateinit var webView: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelMovieDetail = ViewModelProvider(this)[MovieByIdViewModel::class.java]
        reviewsViewModel = ViewModelProvider(this)[ReviewsViewModel::class.java]
        videosViewModel = ViewModelProvider(this)[VideosViewModel::class.java]

        binding.recyclerReviews.layoutManager = LinearLayoutManager(this)

        var idMovie = intent.getIntExtra(Constant.ID_MOVIE,0)

//        getMovieById(idMovie = idMovie, apiKey = apiKey)
//        getReviews(idMovie = idMovie, apiKey = apiKey)
//        getVideos(apiKey, movieId = idMovie)

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

        videosViewModel.videoData.observe(this){
            var videoKey = ""
            for (i in it.results!!.indices){
                if (it.results[i]?.name.equals("Official Trailer")){
                    videoKey = it.results[i]!!.key!!
                }
            }
            webView = binding.webview
            webView.settings.javaScriptEnabled = true
            webView.webChromeClient = WebChromeClient()
            Log.d("KEY-VIDEOS", "onCreate: $videoKey")
            val videoUrl = "https://www.youtube.com/embed/$videoKey"
            webView.loadUrl(videoUrl)
        }
    }

//    private fun getMovieById(idMovie : Int, apiKey : String){
//        viewModelMovieDetail.getMovieById(idMovie,apiKey)
//    }
//    private fun getReviews(idMovie: Int, apiKey : String){
//        reviewsViewModel.getReviews(idMovie, apiKey)
//    }
//    private fun getVideos(apiKey: String,movieId : Int){
//        videosViewModel.getMovies(apiKey,movieId)
//    }
}