package guz.roman.testtask.model.data


import com.squareup.moshi.Json

data class RestorauntModel(
    val id: String?,
    val alias: String?,
    val name: String?,
    val imageUrl: String?,
    val isClaimed: Boolean?,
    val isClosed: Boolean?,
    val url: String?,
    val phone: String?,
    val displayPhone: String?,
    val reviewCount: Int?,
    val categories: List<Category>?,
    val rating: Double?,
    val location: Location?,
    val coordinates: Coordinates?,
    val photos: List<String>?,
    val price: String?,
    val hours: List<Hour>?,
    val transactions: List<String>?,
    val specialHours: List<SpecialHour>?
)