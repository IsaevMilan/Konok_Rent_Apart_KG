package com.airbnbclone.app.presentation.screens.booking;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\fJ\u0014\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0015J\u0006\u0010\u0016\u001a\u00020\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/airbnbclone/app/presentation/screens/booking/AddCardViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/airbnbclone/app/presentation/screens/booking/AddCardUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateCardNumber", "", "value", "", "updateCardholder", "updateExpiry", "updateCvv", "toggleCvvVisibility", "saveCard", "onSuccess", "Lkotlin/Function0;", "clearError", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AddCardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.airbnbclone.app.presentation.screens.booking.AddCardUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.airbnbclone.app.presentation.screens.booking.AddCardUiState> uiState = null;
    
    @javax.inject.Inject()
    public AddCardViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.airbnbclone.app.presentation.screens.booking.AddCardUiState> getUiState() {
        return null;
    }
    
    public final void updateCardNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void updateCardholder(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void updateExpiry(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void updateCvv(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void toggleCvvVisibility() {
    }
    
    public final void saveCard(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void clearError() {
    }
}