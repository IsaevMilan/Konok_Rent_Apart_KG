package com.airbnbclone.app.data.repository.mock

import com.airbnbclone.app.domain.entities.Coordinates
import com.airbnbclone.app.domain.entities.Host
import com.airbnbclone.app.domain.entities.Listing
import com.airbnbclone.app.domain.entities.Review
import com.airbnbclone.app.domain.repository.ListingRepository
import com.airbnbclone.app.domain.repository.ListingResult
import com.airbnbclone.app.domain.repository.ReviewResult

class MockListingRepository : ListingRepository {
    
    private val mockListings = listOf(
        Listing(
            id = "listing1",
            title = "Уютная квартира в центре",
            description = "Прекрасная квартира с видом на город",
            location = "Москва, Центральный район",
            address = "ул. Тверская, 10",
            price = 3500.0,
            rating = 4.8,
            reviewsCount = 127,
            images = listOf(
                "https://example.com/image1.jpg",
                "https://example.com/image2.jpg"
            ),
            host = Host(
                id = "host1",
                name = "Анна",
                avatar = null,
                joinedDate = System.currentTimeMillis() - 86400000L * 365 * 2,
                isSuperhost = true
            ),
            amenities = listOf("Wi-Fi", "Кухня", "Кондиционер", "Стиральная машина"),
            propertyType = "Квартира",
            bedrooms = 2,
            bathrooms = 1,
            maxGuests = 4,
            coordinates = Coordinates(55.7558, 37.6173)
        ),
        Listing(
            id = "listing2",
            title = "Современный лофт",
            description = "Просторный лофт в стиле лофт",
            location = "Санкт-Петербург, Невский проспект",
            address = "Невский пр., 28",
            price = 5000.0,
            rating = 4.9,
            reviewsCount = 89,
            images = listOf("https://example.com/loft1.jpg"),
            host = Host(
                id = "host2",
                name = "Дмитрий",
                isSuperhost = true
            ),
            amenities = listOf("Wi-Fi", "Кухня", "Парковка"),
            propertyType = "Лофт",
            bedrooms = 1,
            bathrooms = 1,
            maxGuests = 2,
            coordinates = Coordinates(59.9343, 30.3351)
        )
    )
    
    override suspend fun getListings(
        page: Int,
        limit: Int,
        minPrice: Double?,
        maxPrice: Double?,
        guests: Int?,
        propertyType: String?,
        amenities: List<String>?,
        location: String?,
        checkIn: Long?,
        checkOut: Long?
    ): ListingResult {
        kotlinx.coroutines.delay(400)
        var filtered = mockListings

        minPrice?.let { min ->
            filtered = filtered.filter { item -> item.price >= min }
        }

        maxPrice?.let { max ->
            filtered = filtered.filter { item -> item.price <= max }
        }

        guests?.let { count ->
            filtered = filtered.filter { item -> item.maxGuests >= count }
        }

        propertyType?.let { type ->
            filtered = filtered.filter { item -> item.propertyType == type }
        }

        location?.let { loc ->
            filtered = filtered.filter { item ->
                item.location.contains(loc, ignoreCase = true)
            }
        }
        val paginated = filtered.drop((page - 1) * limit).take(limit)
        
        return ListingResult(
            listings = paginated,
            total = filtered.size,
            page = page,
            limit = limit
        )
    }
    
    override suspend fun getListingById(listingId: String): Listing {
        kotlinx.coroutines.delay(300)
        return mockListings.find { it.id == listingId }
            ?: throw IllegalArgumentException("Listing not found")
    }
    
    override suspend fun searchListings(query: String, location: String?): List<Listing> {
        kotlinx.coroutines.delay(300)
        return mockListings.filter {
            it.title.contains(query, ignoreCase = true) ||
            it.description.contains(query, ignoreCase = true) ||
            (location != null && it.location.contains(location, ignoreCase = true))
        }
    }
    
    override suspend fun getReviews(listingId: String, page: Int, limit: Int): ReviewResult {
        kotlinx.coroutines.delay(300)
        val reviews = listOf(
            Review(
                id = "review1",
                listingId = listingId,
                userId = "user1",
                userName = "Иван",
                rating = 5,
                comment = "Отличное место!",
                createdAt = System.currentTimeMillis() - 86400000L * 7
            )
        )
        return ReviewResult(
            reviews = reviews,
            averageRating = 4.8,
            total = reviews.size
        )
    }
    
    override suspend fun createReview(listingId: String, rating: Int, comment: String): Review {
        kotlinx.coroutines.delay(400)
        return Review(
            id = "review_${System.currentTimeMillis()}",
            listingId = listingId,
            userId = "user1",
            userName = "Текущий пользователь",
            rating = rating,
            comment = comment,
            createdAt = System.currentTimeMillis()
        )
    }
}

