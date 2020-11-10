package guz.roman.testtask.model.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    val address1: String?,
    val address2: String?,
    val address3: Any?,
    val city: String,
    @Json(name = "zip_code")
    val zipCode: String,
    val country: String,
    val state: String,
    @Json(name = "display_address")
    val displayAddress: List<String>
)