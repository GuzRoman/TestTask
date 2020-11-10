package guz.roman.testtask.model.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Businesse(
    val id: String,
    val alias: String,
    val name: String,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "is_closed")
    val isClosed: Boolean,
    val url: String,
    @Json(name = "review_count")
    val reviewCount: Int,
    val categories: List<Category>,
    val rating: Double,
    val coordinates: Coordinates,
    val transactions: List<String>,
    val location: Location,
    val phone: String,
    @Json(name = "display_phone")
    val displayPhone: String,
    val distance: Double,
    val price: String
)