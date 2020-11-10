package guz.roman.testtask.view

import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import guz.roman.testtask.R
import guz.roman.testtask.model.location.LocationHelper
import guz.roman.testtask.viewmodel.RestorauntListViewModel
import kotlinx.android.synthetic.main.restoraunt_list_fragment.view.*

class RestorauntList : Fragment() {

    private lateinit var viewModel: RestorauntListViewModel
    private lateinit var adapter: Adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var location: LocationHelper

    private lateinit var currentLocation: Location
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.restoraunt_list_fragment, container, false)

        location = LocationHelper()
        adapter = Adapter()
        viewModel = ViewModelProvider(this).get(RestorauntListViewModel::class.java)
        recyclerView = view.myRecyclerWiew
        recyclerView.adapter = adapter

//        location.startListeningUserLocation(requireContext(), object : LocationHelper.MyLocationListener{
//            override fun onLocationChanged(location: Location) {
//                currentLocation = location
//            }
//        })

        setNews()

        return view
    }

    private fun setNews() {
        val news = viewModel.restorauntList
        news.observe(viewLifecycleOwner, Observer {
            adapter.setData(it.businesses)
        })
    }


}