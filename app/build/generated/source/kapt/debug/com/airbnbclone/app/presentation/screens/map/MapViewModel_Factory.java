package com.airbnbclone.app.presentation.screens.map;

import com.airbnbclone.app.domain.repository.ListingRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
    "KotlinInternalInJava"
})
public final class MapViewModel_Factory implements Factory<MapViewModel> {
  private final Provider<ListingRepository> listingRepositoryProvider;

  public MapViewModel_Factory(Provider<ListingRepository> listingRepositoryProvider) {
    this.listingRepositoryProvider = listingRepositoryProvider;
  }

  @Override
  public MapViewModel get() {
    return newInstance(listingRepositoryProvider.get());
  }

  public static MapViewModel_Factory create(Provider<ListingRepository> listingRepositoryProvider) {
    return new MapViewModel_Factory(listingRepositoryProvider);
  }

  public static MapViewModel newInstance(ListingRepository listingRepository) {
    return new MapViewModel(listingRepository);
  }
}
