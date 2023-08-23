package com.example.movietask.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movietask.R
import com.example.movietask.data.model.ResultsItemDiscover

class DiscoverAdapter(val models : List<ResultsItemDiscover?>) :
    RecyclerView.Adapter<DiscoverAdapter.ViewHolder>() {

    private lateinit var itemClickListener: ItemClickListener

    interface ItemClickListener {
        fun onClick(view: View, position: Int, idMovie: Int)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        var imageThumbnail = itemView.findViewById<ImageView>(R.id.img_thumbnail)
        var titleDiscover = itemView.findViewById<TextView>(R.id.tv_title_movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_discover_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500" + models[position]?.posterPath).into(holder.imageThumbnail)
        holder.titleDiscover.text = models[position]?.title!!
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it,position,models[position]?.id!!)
        }
    }

    override fun getItemCount(): Int {
        return models.size
    }
}