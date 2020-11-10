package guz.roman.testtask.model.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Open(
    @Json(name = "is_overnight")
    val isOvernight: Boolean,
    val start: String,
    val end: String,
    val day: Int
)