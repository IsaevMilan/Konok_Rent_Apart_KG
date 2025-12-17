package com.airbnbclone.app.domain.entities

data class Listing(
    val id: String,
    val title: String,
    val description: String,
    val location: String,
    val address: String? = null,
    val price: Double,
    val rating: Double,
    val reviewsCount: Int,
    val images: List<String>,
    val host: Host,
    val amenities: List<String>,
    val propertyType: String,
    val bedrooms: Int,
    val bathrooms: Int,
    val maxGuests: Int,
    val coordinates: Coordinates? = null
)

data class Host(
    val id: String,
    val name: String,
    val avatar: String? = null,
    val joinedDate: Long? = null,
    val isSuperhost: Boolean = false
)

data class Coordinates(
    val lat: Double,
    val lng: Double
)

