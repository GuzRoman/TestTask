package guz.roman.testtask.model.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RestorauntModel(
    val id: String,
    val alias: String,
    val name: String,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "is_claimed")
    val isClaimed: Boolean,
    @Json(name = "is_closed")
    val isClosed: Boolean,
    val url: String,
    val phone: String,
    @Json(name = "display_phone")
    val displayPhone: String,
    @Json(name = "review_count")
    val reviewCount: Int,
    val categories: List<Category>,
    val rating: Double,
    val location: Location,
    val coordinates: Coordinates,
    val photos: List<String>,
    val price: String,
    val hours: List<Hour>,
    val transactions: List<Any>,
    @Json(name = "special_hours")
    val specialHours: List<SpecialHour>
)