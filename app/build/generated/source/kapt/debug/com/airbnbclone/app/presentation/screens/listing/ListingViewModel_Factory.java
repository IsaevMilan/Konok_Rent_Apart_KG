package com.airbnbclone.app.presentation.screens.listing;

import com.airbnbclone.app.domain.repository.ListingRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class ListingViewModel_Factory implements Factory<ListingViewModel> {
  private final Provider<ListingRepository> listingRepositoryProvider;

  private ListingViewModel_Factory(Provider<ListingRepository> listingRepositoryProvider) {
    this.listingRepositoryProvider = listingRepositoryProvider;
  }

  @Override
  public ListingViewModel get() {
    return newInstance(listingRepositoryProvider.get());
  }

  public static ListingViewModel_Factory create(
      Provider<ListingRepository> listingRepositoryProvider) {
    return new ListingViewModel_Factory(listingRepositoryProvider);
  }

  public static ListingViewModel newInstance(ListingRepository listingRepository) {
    return new ListingViewModel(listingRepository);
  }
}
