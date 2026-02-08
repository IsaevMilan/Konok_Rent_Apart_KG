package com.airbnbclone.app.di;

import com.airbnbclone.app.domain.repository.ListingRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class RepositoryModule_ProvideListingRepositoryFactory implements Factory<ListingRepository> {
  @Override
  public ListingRepository get() {
    return provideListingRepository();
  }

  public static RepositoryModule_ProvideListingRepositoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ListingRepository provideListingRepository() {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideListingRepository());
  }

  private static final class InstanceHolder {
    static final RepositoryModule_ProvideListingRepositoryFactory INSTANCE = new RepositoryModule_ProvideListingRepositoryFactory();
  }
}
