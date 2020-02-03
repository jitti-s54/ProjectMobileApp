package com.example.petlover.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petlover.HomeAdapter
import com.example.petlover.R
import com.example.petlover.User
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

        var users = ArrayList<User>()

        users.add(User("Thai1","Nine"))
        users.add(User("Thai2","Nine"))
        users.add(User("Thai3","Nine"))
        users.add(User("Thai4","Nine"))
        users.add(User("Thai5","Nine"))
        users.add(User("Thai6","Nine"))
        users.add(User("Thai7","Nine"))
        users.add(User("Thai8","Nine"))
        users.add(User("Thai9","Nine"))
        users.add(User("Thai10","Nine"))
        users.add(User("Thai11","Nine"))
        users.add(User("Thai11","Nine"))
        val adapter = HomeAdapter(users)
        recyclerView.adapter = adapter
        return root
    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val recyclerView = root.findViewById(R.id.recyclerview) as RecyclerView
//        recyclerView.layoutManager = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
//
//        var users = ArrayList<User>()
//
//        users.add(User("Thai","Nine"))
//        users.add(User("Thai","Nine"))
//        users.add(User("Thai","Nine"))
//        users.add(User("Thai","Nine"))
//        users.add(User("Thai","Nine"))
//        users.add(User("Thai","Nine"))
//        users.add(User("Thai","Nine"))
//        users.add(User("Thai","Nine"))
//        val adapter = HomeAdapter(users)
//        recyclerView.adapter = adapter
//    }
}