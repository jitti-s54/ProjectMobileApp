package com.example.petlover.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petlover.R
import java.util.ArrayList

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = root.findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
//        FragmentActivity.
        var users = ArrayList<Model>()
        users.add(
            Model(
                "nine1",
                R.drawable.femenine,
                "2018-12-12",
                "Khon kean",
                "081-191-1669",
                R.drawable.cat,
                R.drawable.love
            )
        )
        users.add(
            Model(
                "Nine2",
                R.drawable.male,
                "2018-12-12",
                "Khon kean",
                "081-191-1669",
                R.drawable.corgi,
                R.drawable.love
            )
        )
        users.add(
            Model(
                "Nine3",
                R.drawable.femenine,
                "2018-12-12",
                "Khon kean",
                "081-191-1669",
                R.drawable.cat,
                R.drawable.love
            )
        )
        users.add(
            Model(
                "Nine4",
                R.drawable.femenine,
                "2018-12-12",
                "Khon kean",
                "081-191-1669",
                R.drawable.corgi,
                R.drawable.love
            )
        )
        users.add(
            Model(
                "Nine6",
                R.drawable.male,
                "2018-12-12",
                "Khon kean",
                "081-191-1669",
                R.drawable.cat,
                R.drawable.love
            )
        )
        users.add(
            Model(
                "Nine7",
                R.drawable.male,
                "2018-12-12",
                "Khon kean",
                "081-191-1669",
                R.drawable.cat,
                R.drawable.love
            )
        )
        users.add(
            Model(
                "Nine8",
                R.drawable.femenine,
                "2018-12-12",
                "Khon kean",
                "081-191-1669",
                R.drawable.cat,
                R.drawable.love
            )
        )
        users.add(
            Model(
                "Nine9",
                R.drawable.male,
                "2018-12-12",
                "Khon kean",
                "081-191-1669",
                R.drawable.cat,
                R.drawable.love
            )
        )
        users.add(
            Model(
                "Nine10",
                R.drawable.femenine,
                "2018-12-12",
                "Khon kean",
                "081-191-1669",
                R.drawable.cat,
                R.drawable.love
            )
        )
        users.add(
            Model(
                "Nine11",
                R.drawable.femenine,
                "2018-12-12",
                "Khon kean",
                "081-191-1669",
                R.drawable.cat,
                R.drawable.love
            )
        )
        users.add(
            Model(
                "Nine11",
                R.drawable.femenine,
                "2018-12-12",
                "Khon kean",
                "081-191-1669",
                R.drawable.corgi,
                R.drawable.love
            )
        )
        val adapter = HomeAdapter(users)
        recyclerView.adapter = adapter
        return root
    }

}