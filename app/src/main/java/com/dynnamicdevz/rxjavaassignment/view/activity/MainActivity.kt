package com.dynnamicdevz.rxjavaassignment.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import com.dynnamicdevz.rxjavaassignment.R
import com.dynnamicdevz.rxjavaassignment.databinding.ActivityMainBinding
import com.dynnamicdevz.rxjavaassignment.model.data.AlexisResponseItem
import com.dynnamicdevz.rxjavaassignment.view.adapter.NavFragmentAdapter
import com.dynnamicdevz.rxjavaassignment.view.fragment.AlexisSelector
import com.dynnamicdevz.rxjavaassignment.view.fragment.RepoDetailsFragment
import com.dynnamicdevz.rxjavaassignment.viewmodel.alexisViewModel

class MainActivity : AppCompatActivity(), AlexisSelector {

    private val viewModel by viewModels<alexisViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var navFragAdap: NavFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navFragAdap = NavFragmentAdapter(supportFragmentManager)
        binding.mainViewPager.adapter = navFragAdap

        binding.mainViewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                binding.mainMenu.selectedItemId = if(position==0)R.id.list_repo_item else R.id.grid_repo_item
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

        binding.mainMenu.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.list_repo_item ->{
                    binding.mainViewPager.currentItem = 0
                }else->{
                binding.mainViewPager.currentItem = 1
            }
            }
            true
        }

    }

    override fun openDetailsFragment(result: AlexisResponseItem) {
        val fragment = RepoDetailsFragment.getInstance(result)
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right,android.R.anim.slide_in_left,android.R.anim.slide_out_right)
            .add(R.id.details_frame, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }
}