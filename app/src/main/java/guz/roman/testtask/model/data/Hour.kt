package guz.roman.testtask.model.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hour(
    val `open`: List<Open>?,
    val hoursType: String?,
    val isOpenNow: Boolean?
)