package guz.roman.testtask.model.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    val address1: String?,
    val address2: String?,
    val address3: String?,
    val city: String?,
    val zipCode: String?,
    val country: String?,
    val state: String?,
    val displayAddress: List<String>?,
    val crossStreets: String?
)