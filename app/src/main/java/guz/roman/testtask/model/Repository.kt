package guz.roman.testtask.model

import guz.roman.testtask.model.data.BusinessesModel
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getClosestRestoraunts(latitude: Double,
                                      longitude: Double): Flow<Result<BusinessesModel>>

}