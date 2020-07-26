package com.georgegtony.tunatheatre

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_cinema_item.view.*

class CinemaAdapter(val context: Context?, val mCinemaList: List<String>) : RecyclerView.Adapter<CinemaAdapter.CinemaAdapterVH>() {



    inner class CinemaAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(cinemaName: String) {
            itemView.tv_cinemaName.text = cinemaName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaAdapterVH {
        val inflate = LayoutInflater.from(context).inflate(R.layout.adapter_cinema_item,null)
        return CinemaAdapterVH(inflate)
    }

    override fun getItemCount(): Int {
        return mCinemaList.size
    }

    override fun onBindViewHolder(holder: CinemaAdapterVH, position: Int) {
        holder.bindItem(mCinemaList[position])
    }




}
