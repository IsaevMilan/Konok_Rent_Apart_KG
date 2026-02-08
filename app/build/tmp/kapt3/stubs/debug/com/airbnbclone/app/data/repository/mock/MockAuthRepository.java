package com.airbnbclone.app.data.repository.mock;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\tJ.\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0019\u001a\u00020\u0010H\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096@\u00a2\u0006\u0002\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/airbnbclone/app/data/repository/mock/MockAuthRepository;", "Lcom/airbnbclone/app/domain/repository/AuthRepository;", "<init>", "()V", "login", "Lcom/airbnbclone/app/domain/repository/AuthResult;", "phoneOrEmail", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "phone", "email", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendVerificationCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyCode", "code", "socialLogin", "provider", "token", "refreshToken", "Lcom/airbnbclone/app/domain/repository/TokenPair;", "logout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUser", "Lcom/airbnbclone/app/domain/entities/User;", "app_debug"})
public final class MockAuthRepository implements com.airbnbclone.app.domain.repository.AuthRepository {
    
    public MockAuthRepository() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.lang.String phoneOrEmail, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.repository.AuthResult> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object register(@org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.repository.AuthResult> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object sendVerificationCode(@org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object verifyCode(@org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.repository.AuthResult> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object socialLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String provider, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.repository.AuthResult> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object refreshToken(@org.jetbrains.annotations.NotNull()
    java.lang.String refreshToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.repository.TokenPair> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.entities.User> $completion) {
        return null;
    }
}