package guz.roman.testtask.model

import guz.roman.testtask.model.data.RestorauntModel
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getClosestRestoraunts(latitude: Double,
                                      longitude: Double): Flow<Result<List<RestorauntModel>>>

}