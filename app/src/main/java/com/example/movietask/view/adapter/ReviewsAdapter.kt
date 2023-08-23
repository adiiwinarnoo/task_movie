package com.example.movietask.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movietask.R
import com.example.movietask.data.model.ResultsItemReviews

class ReviewsAdapter(val models : List<ResultsItemReviews?>) :
    RecyclerView.Adapter<ReviewsAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var tvUsername = itemView.findViewById<TextView>(R.id.tv_username)
        var tvContentReviews = itemView.findViewById<TextView>(R.id.tv_content_reviews)
        var tvContentRating = itemView.findViewById<TextView>(R.id.tv_rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reviews, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvUsername.text = models[position]?.authorDetails?.username
        holder.tvContentReviews.text = models[position]!!.content
        val rating = models[position]?.authorDetails?.rating ?: 0
        holder.tvContentRating.text = "Rating Movie is $rating"
    }

    override fun getItemCount(): Int {
        return models.size
    }
}