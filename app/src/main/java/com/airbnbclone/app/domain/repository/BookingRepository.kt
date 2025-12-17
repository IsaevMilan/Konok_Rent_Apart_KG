package com.airbnbclone.app.domain.repository

import com.airbnbclone.app.domain.entities.Booking

interface BookingRepository {
    suspend fun createBooking(
        listingId: String,
        checkIn: Long,
        checkOut: Long,
        guests: Int,
        paymentMethodId: String
    ): Booking
    
    suspend fun getBookings(
        userId: String,
        status: String? = null,
        page: Int = 1,
        limit: Int = 20
    ): BookingResult
    
    suspend fun getBookingById(bookingId: String): Booking
    suspend fun cancelBooking(bookingId: String)
}

data class BookingResult(
    val bookings: List<Booking>,
    val total: Int
)

