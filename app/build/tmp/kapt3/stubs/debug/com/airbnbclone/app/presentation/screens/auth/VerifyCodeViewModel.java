package com.airbnbclone.app.presentation.screens.auth;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J\u0014\u0010\u0012\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014J\u0006\u0010\u0015\u001a\u00020\u0010J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u0006\u0010\u0017\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/airbnbclone/app/presentation/screens/auth/VerifyCodeViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/airbnbclone/app/domain/repository/AuthRepository;", "phoneNumber", "", "<init>", "(Lcom/airbnbclone/app/domain/repository/AuthRepository;Ljava/lang/String;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/airbnbclone/app/presentation/screens/auth/VerifyCodeUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateCode", "", "value", "verifyCode", "onSuccess", "Lkotlin/Function0;", "resendCode", "startResendCountdown", "clearError", "app_debug"})
public final class VerifyCodeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.airbnbclone.app.domain.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String phoneNumber = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.airbnbclone.app.presentation.screens.auth.VerifyCodeUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.airbnbclone.app.presentation.screens.auth.VerifyCodeUiState> uiState = null;
    
    public VerifyCodeViewModel(@org.jetbrains.annotations.NotNull()
    com.airbnbclone.app.domain.repository.AuthRepository authRepository, @org.jetbrains.annotations.Nullable()
    java.lang.String phoneNumber) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.airbnbclone.app.presentation.screens.auth.VerifyCodeUiState> getUiState() {
        return null;
    }
    
    public final void updateCode(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void verifyCode(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void resendCode() {
    }
    
    private final void startResendCountdown() {
    }
    
    public final void clearError() {
    }
}