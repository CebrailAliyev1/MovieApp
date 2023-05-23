package com.example.movieapi.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapi.R
import com.example.movieapi.model.Movie
import com.squareup.picasso.Picasso

class NextActivityAdapter (list : List<Movie>) : RecyclerView.Adapter<NextActivityAdapter.ViewHolder>() {
    var list : List<Movie>
    init {
        this.list=list
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var adult = itemView.findViewById<TextView>(R.id.textView)
        var original_language = itemView.findViewById<TextView>(R.id.textView2)
        var original_title =itemView.findViewById<TextView>(R.id.textView3)
        var overview =itemView.findViewById<TextView>(R.id.textView4)
        var poster_path = itemView.findViewById<ImageView>(R.id.imageView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.adult.setText(list.get(position).adult)
        holder.original_language.setText(list.get(position).original_language)
        holder.original_title.setText(list.get(position).original_title)
        holder.overview.setText(list.get(position).overview)
        Picasso.get().load(Uri.parse("https://image.tmdb.org/t/p/w500"+ list.get(position).poster_path)).resize(800, 800).centerCrop().into(holder.poster_path)
    }
}