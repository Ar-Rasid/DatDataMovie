package com.example.datamovie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datamovie.R
import com.example.datamovie.model.Results

class MovieAdapter(private val context: Context, private val resultList: List<Results>) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Inisialisasi elemen-elemen tampilan di sini
        val imgPoster: ImageView = itemView.findViewById(R.id.imgMovie)
        val titleMovie: TextView = itemView.findViewById(R.id.titleMovie)
        val descriptionMovie: TextView = itemView.findViewById(R.id.descriptionMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        val inflater = LayoutInflater.from(parent.context)
        view = inflater.inflate(R.layout.item_movie, parent, false)

        val viewHolder = MyViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Mengisi elemen-elemen tampilan dengan data dari posisi tertentu di sini
        holder.titleMovie.text = resultList[position].title
        holder.descriptionMovie.text = resultList[position].overview
        Glide.with(context).load("https://image.tmdb.org/t/p/w185" + resultList[position].posterPath).into(holder.imgPoster)
    }

    override fun getItemCount(): Int {
        // Mengembalikan jumlah total item di sini
        return resultList.size
    }
}