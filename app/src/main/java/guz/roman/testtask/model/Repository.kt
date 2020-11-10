package guz.roman.testtask.model

import kotlinx.coroutines.flow.Flow
import guz.roman.testtask.model.data.RestorauntModel

interface Repository {

    suspend fun getClosestRestoraunts(latitude: Double,
                                      longitude: Double): Flow<Result<List<RestorauntModel>>>

}