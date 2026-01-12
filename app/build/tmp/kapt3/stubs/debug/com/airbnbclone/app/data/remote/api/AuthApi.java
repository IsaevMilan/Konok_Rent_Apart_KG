package com.airbnbclone.app.data.remote.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/airbnbclone/app/data/remote/api/AuthApi;", "", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "login", "Lcom/airbnbclone/app/data/remote/dto/AuthResponseDto;", "request", "Lcom/airbnbclone/app/data/remote/dto/LoginRequestDto;", "(Lcom/airbnbclone/app/data/remote/dto/LoginRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "Lcom/airbnbclone/app/data/remote/dto/RegisterRequestDto;", "(Lcom/airbnbclone/app/data/remote/dto/RegisterRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendVerificationCode", "", "phone", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyCode", "Lcom/airbnbclone/app/data/remote/dto/VerifyCodeRequestDto;", "(Lcom/airbnbclone/app/data/remote/dto/VerifyCodeRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AuthApi {
    @org.jetbrains.annotations.NotNull()
    private final io.ktor.client.HttpClient client = null;
    
    public AuthApi(@org.jetbrains.annotations.NotNull()
    io.ktor.client.HttpClient client) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull()
    com.airbnbclone.app.data.remote.dto.LoginRequestDto request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.data.remote.dto.AuthResponseDto> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object register(@org.jetbrains.annotations.NotNull()
    com.airbnbclone.app.data.remote.dto.RegisterRequestDto request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.data.remote.dto.AuthResponseDto> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sendVerificationCode(@org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object verifyCode(@org.jetbrains.annotations.NotNull()
    com.airbnbclone.app.data.remote.dto.VerifyCodeRequestDto request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.data.remote.dto.AuthResponseDto> $completion) {
        return null;
    }
}