package com.example.foods.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.foods.databinding.ActivityMainBinding
import com.example.foods.ui.adapter.ViewPagerAdapter
import com.example.foods.utils.FakeData
import com.google.android.material.button.MaterialButton
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ViewPagerAdapter

    private lateinit var viewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindViews()
    }

    private fun bindViews() {
        viewPager = binding.viewpager

        adapter = ViewPagerAdapter(FakeData.viewpagerData)
        viewPager.adapter = adapter

        val nextBtn : MaterialButton = binding.nextButton
        val backBtn : MaterialButton = binding.backButton

        nextBtn.setOnClickListener{
            viewPager.setCurrentItem(getNextPossibleItemIndex(+1), true)
        }

        backBtn.setOnClickListener{
            viewPager.setCurrentItem(getNextPossibleItemIndex(-1), true)
        }

        viewPager.isUserInputEnabled = false

    }

    private fun getNextPossibleItemIndex(change: Int): Int {

        val currentIndex: Int = viewPager.currentItem
        val total : Int = viewPager.adapter!!.itemCount

        if (currentIndex + change < 0) {
            return 0
        }

        if (currentIndex + change >= total) {
            return total
        }

        return abs((currentIndex + change) % total)
    }

}