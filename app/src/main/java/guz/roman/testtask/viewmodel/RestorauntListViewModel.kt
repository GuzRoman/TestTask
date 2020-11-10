package guz.roman.testtask.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import guz.roman.testtask.model.RepositoryImpl
import guz.roman.testtask.model.api.NetService
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RestorauntListViewModel : ViewModel() {

    private val repository = RepositoryImpl(NetService())
    val restorauntList = MutableLiveData<List<RestorauntModel>>()

    init {
        getData()

    }

    private fun getData() = viewModelScope.launch{
        fetchData(37.786882,-122.399972)
    }

    private suspend fun fetchData(lag: Double, lon: Double){
        val response = repository.getClosestRestoraunts(lag, lon)
        response.collect { it.onSuccess { restorauntList.postValue(it) } }
        Log.e("NetTest", response.toString())
    }

}