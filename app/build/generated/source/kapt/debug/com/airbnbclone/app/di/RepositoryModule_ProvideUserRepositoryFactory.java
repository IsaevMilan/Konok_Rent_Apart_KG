package com.airbnbclone.app.di;

import com.airbnbclone.app.domain.repository.UserRepository;
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
public final class RepositoryModule_ProvideUserRepositoryFactory implements Factory<UserRepository> {
  @Override
  public UserRepository get() {
    return provideUserRepository();
  }

  public static RepositoryModule_ProvideUserRepositoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static UserRepository provideUserRepository() {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideUserRepository());
  }

  private static final class InstanceHolder {
    static final RepositoryModule_ProvideUserRepositoryFactory INSTANCE = new RepositoryModule_ProvideUserRepositoryFactory();
  }
}
