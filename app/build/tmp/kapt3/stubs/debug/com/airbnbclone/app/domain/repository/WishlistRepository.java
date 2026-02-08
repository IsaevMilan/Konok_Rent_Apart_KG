package com.airbnbclone.app.domain.repository;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J2\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u0013\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\u001a\u00c0\u0006\u0003"}, d2 = {"Lcom/airbnbclone/app/domain/repository/WishlistRepository;", "", "getWishlists", "", "Lcom/airbnbclone/app/domain/entities/Wishlist;", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWishlist", "name", "description", "isPublic", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWishlist", "wishlist", "(Lcom/airbnbclone/app/domain/entities/Wishlist;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWishlist", "", "wishlistId", "addListingToWishlist", "listingId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeListingFromWishlist", "getWishlistListings", "Lcom/airbnbclone/app/domain/entities/Listing;", "app_debug"})
public abstract interface WishlistRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getWishlists(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.airbnbclone.app.domain.entities.Wishlist>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createWishlist(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String description, boolean isPublic, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.entities.Wishlist> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateWishlist(@org.jetbrains.annotations.NotNull()
    com.airbnbclone.app.domain.entities.Wishlist wishlist, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.entities.Wishlist> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteWishlist(@org.jetbrains.annotations.NotNull()
    java.lang.String wishlistId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addListingToWishlist(@org.jetbrains.annotations.NotNull()
    java.lang.String wishlistId, @org.jetbrains.annotations.NotNull()
    java.lang.String listingId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeListingFromWishlist(@org.jetbrains.annotations.NotNull()
    java.lang.String wishlistId, @org.jetbrains.annotations.NotNull()
    java.lang.String listingId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getWishlistListings(@org.jetbrains.annotations.NotNull()
    java.lang.String wishlistId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.airbnbclone.app.domain.entities.Listing>> $completion);
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}