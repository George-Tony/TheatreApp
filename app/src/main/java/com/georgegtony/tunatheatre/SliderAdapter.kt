package com.georgegtony.tunatheatre

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.georgegtony.tunatheatre.mvp.model.Sliders
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.image_slider_item.view.*

class SliderAdapter(val context: Context, var mSliderItems: List<Sliders>) :
    SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterVH {
        val inflate = LayoutInflater.from(context).inflate(R.layout.image_slider_item,null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(holder: SliderAdapterVH, position: Int) {
        holder.bindView(mSliderItems[position])
    }

    override fun getCount(): Int {
        return mSliderItems.size
    }

    class SliderAdapterVH(itemview:View) : SliderViewAdapter.ViewHolder(itemview) {

        fun bindView(sliders: Sliders) {

            itemView.tv_movieName.text = sliders.name
            val requestOption = RequestOptions()
                .placeholder(R.drawable.emagine_white_logo).centerCrop()
                .centerCrop()
            Glide.with(itemView.context)
                .load(sliders.image)
                .apply(requestOption)
                .fitCenter()
                .into(itemView.iv_header_slider);



        }

    }



}