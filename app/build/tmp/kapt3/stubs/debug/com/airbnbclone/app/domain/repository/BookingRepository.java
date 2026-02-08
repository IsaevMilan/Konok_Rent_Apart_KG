package com.airbnbclone.app.domain.repository;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\fJ6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0019\u00c0\u0006\u0003"}, d2 = {"Lcom/airbnbclone/app/domain/repository/BookingRepository;", "", "createBooking", "Lcom/airbnbclone/app/domain/entities/Booking;", "listingId", "", "checkIn", "", "checkOut", "guests", "", "paymentMethodId", "(Ljava/lang/String;JJILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookings", "Lcom/airbnbclone/app/domain/repository/BookingResult;", "userId", "status", "page", "limit", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookingById", "bookingId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelBooking", "", "app_debug"})
public abstract interface BookingRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createBooking(@org.jetbrains.annotations.NotNull()
    java.lang.String listingId, long checkIn, long checkOut, int guests, @org.jetbrains.annotations.NotNull()
    java.lang.String paymentMethodId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.entities.Booking> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBookings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, int page, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.repository.BookingResult> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBookingById(@org.jetbrains.annotations.NotNull()
    java.lang.String bookingId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.entities.Booking> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object cancelBooking(@org.jetbrains.annotations.NotNull()
    java.lang.String bookingId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}