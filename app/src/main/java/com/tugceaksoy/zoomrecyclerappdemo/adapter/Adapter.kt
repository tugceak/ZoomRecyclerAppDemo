package com.tugceaksoy.zoomrecyclerappdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tugceaksoy.zoomrecyclerappdemo.model.Tour
import com.tugceaksoy.zoomrecyclerappdemo.databinding.ItemCardBinding
import com.tugceaksoy.zoomrecyclerappdemo.utils.GlideUtils

class Adapter( private var countryList:  ArrayList<Tour>):RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(val binding:ItemCardBinding) :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var tour = countryList[position]
        holder.binding.tourImage.clipToOutline = true

        holder.binding.run {
            tourImage.resume()
            tourTitle.text = tour.title
            tourDescription.text = tour.description
            ratingBar.rating = tour.rating!!
            tour.let {
                it.url?.let { it1 ->
                    GlideUtils.urlToImageView(
                        tourImage.context,
                        it1, tourImage
                    )

                }

            }

        }


    }

    override fun getItemCount(): Int {
       return countryList.size
    }
    fun setTourList(tourList: ArrayList<Tour>) {
        countryList = tourList
        notifyDataSetChanged()
    }
}
