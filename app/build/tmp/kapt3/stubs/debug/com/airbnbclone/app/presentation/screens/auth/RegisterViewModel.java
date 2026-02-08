package com.airbnbclone.app.presentation.screens.auth;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u001a\u0010\u0017\u001a\u00020\u000e2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\u0019J\u0006\u0010\u001a\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/airbnbclone/app/presentation/screens/auth/RegisterViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/airbnbclone/app/domain/repository/AuthRepository;", "<init>", "(Lcom/airbnbclone/app/domain/repository/AuthRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/airbnbclone/app/presentation/screens/auth/RegisterUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "updatePhone", "", "value", "", "updateEmail", "updatePassword", "updateConfirmPassword", "updateName", "togglePasswordVisibility", "toggleConfirmPasswordVisibility", "register", "onSuccess", "Lkotlin/Function1;", "clearError", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RegisterViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.airbnbclone.app.domain.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.airbnbclone.app.presentation.screens.auth.RegisterUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.airbnbclone.app.presentation.screens.auth.RegisterUiState> uiState = null;
    
    @javax.inject.Inject()
    public RegisterViewModel(@org.jetbrains.annotations.NotNull()
    com.airbnbclone.app.domain.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.airbnbclone.app.presentation.screens.auth.RegisterUiState> getUiState() {
        return null;
    }
    
    public final void updatePhone(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void updateEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void updatePassword(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void updateConfirmPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void updateName(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void togglePasswordVisibility() {
    }
    
    public final void toggleConfirmPasswordVisibility() {
    }
    
    public final void register(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess) {
    }
    
    public final void clearError() {
    }
}