package com.airbnbclone.app.presentation.screens.listing;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0006\u0010\u0012\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/airbnbclone/app/presentation/screens/listing/ListingViewModel;", "Landroidx/lifecycle/ViewModel;", "listingRepository", "Lcom/airbnbclone/app/domain/repository/ListingRepository;", "<init>", "(Lcom/airbnbclone/app/domain/repository/ListingRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/airbnbclone/app/presentation/screens/listing/ListingUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "listingId", "", "init", "", "loadListing", "refresh", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ListingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.airbnbclone.app.domain.repository.ListingRepository listingRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.airbnbclone.app.presentation.screens.listing.ListingUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.airbnbclone.app.presentation.screens.listing.ListingUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String listingId = "";
    
    @javax.inject.Inject()
    public ListingViewModel(@org.jetbrains.annotations.NotNull()
    com.airbnbclone.app.domain.repository.ListingRepository listingRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.airbnbclone.app.presentation.screens.listing.ListingUiState> getUiState() {
        return null;
    }
    
    public final void init(@org.jetbrains.annotations.NotNull()
    java.lang.String listingId) {
    }
    
    private final void loadListing() {
    }
    
    public final void refresh() {
    }
}