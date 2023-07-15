package com.example.foods.ui.adapter

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.airbnb.lottie.LottieAnimationView
import com.example.foods.data.model.ViewPagerModel
import com.example.foods.databinding.ItemViewpagerBinding

class ViewHolderPager(private val binding: ItemViewpagerBinding) : ViewHolder(binding.root){

    private var animationTitle = binding.animationTitle
    private var lottie = binding.itemLottie

    fun bindViews(model: ViewPagerModel) {
        animationTitle.text = model.title
        lottie.setAnimation(model.lottie)
    }
}