package com.airbnbclone.app.domain.entities

data class Booking(
    val id: String,
    val listingId: String,
    val userId: String,
    val checkIn: Long,
    val checkOut: Long,
    val guests: Int,
    val totalPrice: Double,
    val serviceFee: Double,
    val status: BookingStatus,
    val createdAt: Long
)

enum class BookingStatus {
    PENDING,
    CONFIRMED,
    CANCELLED
}

