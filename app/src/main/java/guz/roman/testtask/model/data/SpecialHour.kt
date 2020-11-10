package guz.roman.testtask.model.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpecialHour(
    val date: String?,
    val isClosed: Any?,
    val start: String?,
    val end: String?,
    val isOvernight: Boolean?
)