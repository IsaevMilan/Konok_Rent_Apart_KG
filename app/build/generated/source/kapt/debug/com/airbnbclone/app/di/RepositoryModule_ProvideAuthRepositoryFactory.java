package com.airbnbclone.app.di;

import com.airbnbclone.app.domain.repository.AuthRepository;
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
    "KotlinInternalInJava"
})
public final class RepositoryModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  @Override
  public AuthRepository get() {
    return provideAuthRepository();
  }

  public static RepositoryModule_ProvideAuthRepositoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AuthRepository provideAuthRepository() {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideAuthRepository());
  }

  private static final class InstanceHolder {
    private static final RepositoryModule_ProvideAuthRepositoryFactory INSTANCE = new RepositoryModule_ProvideAuthRepositoryFactory();
  }
}
