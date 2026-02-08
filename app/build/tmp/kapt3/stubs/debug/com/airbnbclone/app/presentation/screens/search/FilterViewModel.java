package com.airbnbclone.app.presentation.screens.search;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/airbnbclone/app/presentation/screens/search/FilterViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/airbnbclone/app/presentation/screens/search/FilterUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "updatePriceRange", "", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "updateGuests", "count", "", "incrementGuests", "decrementGuests", "toggleAmenity", "amenity", "", "togglePropertyType", "type", "resetFilters", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class FilterViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.airbnbclone.app.presentation.screens.search.FilterUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.airbnbclone.app.presentation.screens.search.FilterUiState> uiState = null;
    
    @javax.inject.Inject()
    public FilterViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.airbnbclone.app.presentation.screens.search.FilterUiState> getUiState() {
        return null;
    }
    
    public final void updatePriceRange(@org.jetbrains.annotations.NotNull()
    kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> range) {
    }
    
    public final void updateGuests(int count) {
    }
    
    public final void incrementGuests() {
    }
    
    public final void decrementGuests() {
    }
    
    public final void toggleAmenity(@org.jetbrains.annotations.NotNull()
    java.lang.String amenity) {
    }
    
    public final void togglePropertyType(@org.jetbrains.annotations.NotNull()
    java.lang.String type) {
    }
    
    public final void resetFilters() {
    }
}