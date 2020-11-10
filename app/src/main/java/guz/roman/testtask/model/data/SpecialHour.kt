package guz.roman.testtask.model.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpecialHour(
    val date: String,
    @Json(name = "is_closed")
    val isClosed: Any,
    val start: String,
    val end: String,
    @Json(name = "is_overnight")
    val isOvernight: Boolean
)