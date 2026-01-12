package com.airbnbclone.app.domain.repository

import com.airbnbclone.app.domain.entities.Listing
import com.airbnbclone.app.domain.entities.Review

interface ListingRepository {
    suspend fun getListings(
        page: Int = 1,
        limit: Int = 20,
        minPrice: Double? = null,
        maxPrice: Double? = null,
        guests: Int? = null,
        propertyType: String? = null,
        amenities: List<String>? = null,
        location: String? = null,
        checkIn: Long? = null,
        checkOut: Long? = null
    ): ListingResult
    
    suspend fun getListingById(listingId: String): Listing
    suspend fun searchListings(query: String, location: String? = null): List<Listing>
    suspend fun getReviews(listingId: String, page: Int = 1, limit: Int = 20): ReviewResult
    suspend fun createReview(listingId: String, rating: Int, comment: String): Review
}

data class ListingResult(
    val listings: List<Listing>,
    val total: Int,
    val page: Int,
    val limit: Int
)

data class ReviewResult(
    val reviews: List<Review>,
    val averageRating: Double,
    val total: Int
)

