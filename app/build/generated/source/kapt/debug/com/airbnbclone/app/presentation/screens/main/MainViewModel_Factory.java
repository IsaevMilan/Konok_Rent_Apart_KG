package com.airbnbclone.app.presentation.screens.main;

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
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<ListingRepository> listingRepositoryProvider;

  private MainViewModel_Factory(Provider<ListingRepository> listingRepositoryProvider) {
    this.listingRepositoryProvider = listingRepositoryProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(listingRepositoryProvider.get());
  }

  public static MainViewModel_Factory create(
      Provider<ListingRepository> listingRepositoryProvider) {
    return new MainViewModel_Factory(listingRepositoryProvider);
  }

  public static MainViewModel newInstance(ListingRepository listingRepository) {
    return new MainViewModel(listingRepository);
  }
}
