package com.georgegtony.tunatheatre

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.georgegtony.tunatheatre.mvp.model.Movie_list
import kotlinx.android.synthetic.main.adapter_movie_item.view.*
import kotlinx.android.synthetic.main.adapter_movie_item.view.tv_movieName

class MovieAdapter(val context: Context?, val mMovieList: List<Movie_list>) :RecyclerView.Adapter<MovieAdapter.MovieAdapterVH>() {



    inner class MovieAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(movieList: Movie_list) {
            // no image in the array
            // cinema name is null so i have given twitterTag
            itemView.tv_movieName.text = movieList.twitterTag

            val requestOption = RequestOptions()
                .placeholder(R.drawable.emagine_white_logo).centerCrop()
                .centerCrop()
            Glide.with(itemView.context)
                .load("https://www.google.com/url?sa=i&url=https%3A%2F%2Fencrypted-tbn2.gstatic.com%2Fimages%3Fq%3Dtbn%3AANd9GcQA_-tL18_rj9zEcjN6n41NEaJm-kRNF9UeOtvksZ4z_OW6jRA9&psig=AOvVaw2MOGWh7CPnimN32PT1kHFG&ust=1595830135132000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKji5NSg6uoCFQAAAAAdAAAAABAD")
                .apply(requestOption)
                .into(itemView.iv_movie_poster);
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapterVH {
        val inflate = LayoutInflater.from(context).inflate(R.layout.adapter_movie_item,null)
        return MovieAdapterVH(inflate)
    }

    override fun getItemCount(): Int {
        return mMovieList.size
    }

    override fun onBindViewHolder(holder: MovieAdapterVH, position: Int) {
        holder.bindItem(mMovieList[position])
    }




}
