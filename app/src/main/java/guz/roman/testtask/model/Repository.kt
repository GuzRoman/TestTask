package guz.roman.testtask.model

import android.content.Context
import guz.roman.testtask.model.data.BusinessesModel
import guz.roman.testtask.model.data.Location
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getClosestRestoraunts(latitude: Double,
                                      longitude: Double): Flow<Result<BusinessesModel>>

    suspend fun getLocationUser(context: Context): android.location.Location
}