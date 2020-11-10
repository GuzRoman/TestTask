package guz.roman.testtask.model.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hour(
    val `open`: List<Open>,
    @Json(name = "hours_type")
    val hoursType: String,
    @Json(name = "is_open_now")
    val isOpenNow: Boolean
)