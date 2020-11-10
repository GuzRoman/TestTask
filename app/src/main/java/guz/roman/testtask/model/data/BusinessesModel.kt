package guz.roman.testtask.model.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BusinessesModel(
    val businesses: List<Businesse>,
    val total: Int,
    val region: Region
)