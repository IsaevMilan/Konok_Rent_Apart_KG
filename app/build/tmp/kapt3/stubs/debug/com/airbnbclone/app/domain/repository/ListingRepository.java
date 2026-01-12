package com.airbnbclone.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\fJ\u0088\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u00a6@\u00a2\u0006\u0002\u0010\u001cJ*\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\u001fJ(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u00172\u0006\u0010!\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00a6@\u00a2\u0006\u0002\u0010\"\u00a8\u0006#"}, d2 = {"Lcom/airbnbclone/app/domain/repository/ListingRepository;", "", "createReview", "Lcom/airbnbclone/app/domain/entities/Review;", "listingId", "", "rating", "", "comment", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getListingById", "Lcom/airbnbclone/app/domain/entities/Listing;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getListings", "Lcom/airbnbclone/app/domain/repository/ListingResult;", "page", "limit", "minPrice", "", "maxPrice", "guests", "propertyType", "amenities", "", "location", "checkIn", "", "checkOut", "(IILjava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReviews", "Lcom/airbnbclone/app/domain/repository/ReviewResult;", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchListings", "query", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ListingRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getListings(int page, int limit, @org.jetbrains.annotations.Nullable()
    java.lang.Double minPrice, @org.jetbrains.annotations.Nullable()
    java.lang.Double maxPrice, @org.jetbrains.annotations.Nullable()
    java.lang.Integer guests, @org.jetbrains.annotations.Nullable()
    java.lang.String propertyType, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> amenities, @org.jetbrains.annotations.Nullable()
    java.lang.String location, @org.jetbrains.annotations.Nullable()
    java.lang.Long checkIn, @org.jetbrains.annotations.Nullable()
    java.lang.Long checkOut, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.repository.ListingResult> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getListingById(@org.jetbrains.annotations.NotNull()
    java.lang.String listingId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.entities.Listing> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchListings(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    java.lang.String location, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.airbnbclone.app.domain.entities.Listing>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getReviews(@org.jetbrains.annotations.NotNull()
    java.lang.String listingId, int page, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.repository.ReviewResult> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createReview(@org.jetbrains.annotations.NotNull()
    java.lang.String listingId, int rating, @org.jetbrains.annotations.NotNull()
    java.lang.String comment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.entities.Review> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}