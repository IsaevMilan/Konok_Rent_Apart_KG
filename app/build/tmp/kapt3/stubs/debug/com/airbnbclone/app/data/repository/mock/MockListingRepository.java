package com.airbnbclone.app.data.repository.mock;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003Jt\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u001aJ&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0096@\u00a2\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010 J&\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010%R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/airbnbclone/app/data/repository/mock/MockListingRepository;", "Lcom/airbnbclone/app/domain/repository/ListingRepository;", "<init>", "()V", "mockListings", "", "Lcom/airbnbclone/app/domain/entities/Listing;", "getListings", "Lcom/airbnbclone/app/domain/repository/ListingResult;", "page", "", "limit", "minPrice", "", "maxPrice", "guests", "propertyType", "", "amenities", "location", "checkIn", "", "checkOut", "(IILjava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getListingById", "listingId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchListings", "query", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReviews", "Lcom/airbnbclone/app/domain/repository/ReviewResult;", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createReview", "Lcom/airbnbclone/app/domain/entities/Review;", "rating", "comment", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MockListingRepository implements com.airbnbclone.app.domain.repository.ListingRepository {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.airbnbclone.app.domain.entities.Listing> mockListings = null;
    
    public MockListingRepository() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getListings(int page, int limit, @org.jetbrains.annotations.Nullable()
    java.lang.Double minPrice, @org.jetbrains.annotations.Nullable()
    java.lang.Double maxPrice, @org.jetbrains.annotations.Nullable()
    java.lang.Integer guests, @org.jetbrains.annotations.Nullable()
    java.lang.String propertyType, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> amenities, @org.jetbrains.annotations.Nullable()
    java.lang.String location, @org.jetbrains.annotations.Nullable()
    java.lang.Long checkIn, @org.jetbrains.annotations.Nullable()
    java.lang.Long checkOut, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.repository.ListingResult> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getListingById(@org.jetbrains.annotations.NotNull()
    java.lang.String listingId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.entities.Listing> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object searchListings(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    java.lang.String location, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.airbnbclone.app.domain.entities.Listing>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getReviews(@org.jetbrains.annotations.NotNull()
    java.lang.String listingId, int page, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.repository.ReviewResult> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object createReview(@org.jetbrains.annotations.NotNull()
    java.lang.String listingId, int rating, @org.jetbrains.annotations.NotNull()
    java.lang.String comment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.entities.Review> $completion) {
        return null;
    }
}