package com.tugceaksoy.zoomrecyclerappdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.tugceaksoy.zoomrecyclerappdemo.R
import com.tugceaksoy.zoomrecyclerappdemo.adapter.Adapter
import com.tugceaksoy.zoomrecyclerappdemo.adapter.CenterZoomLayoutManager
import com.tugceaksoy.zoomrecyclerappdemo.databinding.ActivityMainBinding
import com.tugceaksoy.zoomrecyclerappdemo.model.Tour

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter: Adapter by lazy { Adapter(arrayListOf()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val places = ArrayList<Tour>()
        places.add(Tour("Los Angles","Los Angeles is a sprawling Southern California city and the center of the nation’s film and television industry. Near its iconic Hollywood sign, studios such as Paramount Pictures, Universal and Warner Brothers offer behind-the-scenes tours.",4.5f,"https://images.unsplash.com/photo-1554143091-c41d76e3da15?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80"))
        places.add(Tour("China","China, officially the People's Republic of China, is a country in East Asia and is the world's most populous country, with a population of around 1.428 billion in 2017.",4.5f,"https://images.unsplash.com/photo-1529921879218-f99546d03a9d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80"))
        places.add(
            Tour(
                "Tuvalu ",
                "Tuvalu, in the South Pacific, is an independent island nation within the British Commonwealth. Its 9 islands comprise small, thinly populated atolls and reef islands with palm-fringed beaches and WWII sites.",
                5f,
                "https://images.unsplash.com/photo-1483683804023-6ccdb62f86ef?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80"
            )
        )
        places.add(Tour("Tokyo","Tokyo, Japan’s busy capital, mixes the ultramodern and the traditional, from neon-lit skyscrapers to historic temples. The opulent Meiji Shinto Shrine is known for its towering gate and surrounding woods.",3.5f,"" +
                "https://images.unsplash.com/photo-1540959733332-eab4deabeeaf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1071&q=80"))

        initRecycler(places)

    }
    private fun initRecycler(list :ArrayList<Tour>){
        adapter.setTourList(list)
        binding.toursRV.adapter=adapter
        val linearLayoutManager = CenterZoomLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd = true
        binding.toursRV.layoutManager = linearLayoutManager
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.toursRV)
        binding.toursRV.isNestedScrollingEnabled = false



    }

}