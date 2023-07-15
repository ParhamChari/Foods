package com.example.foods.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.foods.data.model.ViewPagerModel
import com.example.foods.databinding.ItemViewpagerBinding

class ViewPagerAdapter(private val model: List<ViewPagerModel>) : Adapter<ViewHolderPager>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPager =
        ViewHolderPager(
            ItemViewpagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolderPager, position: Int) =
        holder.bindViews(model[position])


    override fun getItemCount(): Int =
        model.size

}