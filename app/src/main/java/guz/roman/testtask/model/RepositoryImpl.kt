package guz.roman.testtask.model

import android.content.Context
import android.util.Log
import guz.roman.testtask.model.api.NetService
import guz.roman.testtask.model.data.BusinessesModel
import guz.roman.testtask.model.data.Location
import guz.roman.testtask.model.location.LocationHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException


class RepositoryImpl(private val netService: NetService) : Repository {

    override suspend fun getLocationUser(context: Context): android.location.Location {
        var myLocation = android.location.Location("")
        LocationHelper().startListeningUserLocation(context, object : LocationHelper.MyLocationListener{
            override fun onLocationChanged(location: android.location.Location) {
                myLocation = location
            }
        })
        return myLocation
    }

        override suspend fun getClosestRestoraunts(
            latitude: Double,
            longitude: Double
        ): Flow<Result<BusinessesModel>> = flow {
            val data = try {
                netService.getClosest(
                    latitude = latitude.toString(),
                    longitude = longitude.toString()
                )
            } catch (e: IOException) {
                emit(Result.failure(e))
                Log.e("NetTest", e.toString())
                return@flow
            }
            emit(Result.success(data))
            Log.e("NetTest", data.toString())
        }.flowOn(Dispatchers.IO)
    }