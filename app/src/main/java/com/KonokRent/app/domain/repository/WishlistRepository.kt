package com.airbnbclone.app.domain.repository

import com.airbnbclone.app.domain.entities.Wishlist

interface WishlistRepository {
    suspend fun getWishlists(userId: String): List<Wishlist>
    suspend fun createWishlist(
        userId: String,
        name: String,
        description: String? = null,
        isPublic: Boolean
    ): Wishlist
    
    suspend fun updateWishlist(wishlist: Wishlist): Wishlist
    suspend fun deleteWishlist(wishlistId: String)
    suspend fun addListingToWishlist(wishlistId: String, listingId: String)
    suspend fun removeListingFromWishlist(wishlistId: String, listingId: String)
    suspend fun getWishlistListings(wishlistId: String): List<com.airbnbclone.app.domain.entities.Listing>
}

