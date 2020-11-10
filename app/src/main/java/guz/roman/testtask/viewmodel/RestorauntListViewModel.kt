package guz.roman.testtask.viewmodel

import android.app.Application
import android.location.Location
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import guz.roman.testtask.model.RepositoryImpl
import guz.roman.testtask.model.api.NetService
import guz.roman.testtask.model.data.BusinessesModel
import guz.roman.testtask.model.location.LocationHelper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RestorauntListViewModel(application: Application) : AndroidViewModel(application) {


    private val repository = RepositoryImpl(NetService())
    val restorauntList = MutableLiveData<BusinessesModel>()
    var myLocation = Location("")

    init {
        foo(application)
        getData()
    }

    private fun foo(application: Application) {
        LocationHelper().startListeningUserLocation(
            application,
            object : LocationHelper.MyLocationListener {
                override fun onLocationChanged(location: Location) {
                    myLocation = location
                }
            })
    }

    private fun getData() = viewModelScope.launch {
        fetchData(myLocation.longitude, myLocation.longitude)
    }

    private suspend fun fetchData(lag: Double, lon: Double) {
        val response = repository.getClosestRestoraunts(lag, lon)
        response.collect { it.onSuccess { restorauntList.postValue(it) } }
        Log.e("NetTest", response.toString())
    }

}