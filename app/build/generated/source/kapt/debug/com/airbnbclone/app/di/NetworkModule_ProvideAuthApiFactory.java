package com.airbnbclone.app.di;

import com.airbnbclone.app.data.remote.api.AuthApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.ktor.client.HttpClient;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class NetworkModule_ProvideAuthApiFactory implements Factory<AuthApi> {
  private final Provider<HttpClient> clientProvider;

  public NetworkModule_ProvideAuthApiFactory(Provider<HttpClient> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  public AuthApi get() {
    return provideAuthApi(clientProvider.get());
  }

  public static NetworkModule_ProvideAuthApiFactory create(Provider<HttpClient> clientProvider) {
    return new NetworkModule_ProvideAuthApiFactory(clientProvider);
  }

  public static AuthApi provideAuthApi(HttpClient client) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideAuthApi(client));
  }
}
