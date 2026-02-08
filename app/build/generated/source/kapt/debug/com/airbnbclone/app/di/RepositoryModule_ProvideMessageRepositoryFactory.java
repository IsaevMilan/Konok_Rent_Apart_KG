package com.airbnbclone.app.di;

import com.airbnbclone.app.domain.repository.MessageRepository;
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
public final class RepositoryModule_ProvideMessageRepositoryFactory implements Factory<MessageRepository> {
  @Override
  public MessageRepository get() {
    return provideMessageRepository();
  }

  public static RepositoryModule_ProvideMessageRepositoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MessageRepository provideMessageRepository() {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideMessageRepository());
  }

  private static final class InstanceHolder {
    static final RepositoryModule_ProvideMessageRepositoryFactory INSTANCE = new RepositoryModule_ProvideMessageRepositoryFactory();
  }
}
