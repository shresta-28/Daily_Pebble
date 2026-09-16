package com.dailypebble

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.dailypebble.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById<ViewPager2>(R.id.benefits_pager)

        val pagerAdapter = object : FragmentStateAdapter(this){
            override fun getItemCount(): Int = 2

            override fun createFragment(position: Int): Fragment {
                return when(position){
                    0 -> PageOneFragment()
                    1 -> PageTwoFragment()
                    else -> PageOneFragment()
                }
            }
        }

        viewPager.adapter = pagerAdapter

        val tabLayout: TabLayout = findViewById<TabLayout>(R.id.dot_tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab: TabLayout.Tab, position: Int ->

        }.attach();
    }
}