package com.airbnbclone.app.presentation.screens.booking;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
    "KotlinInternalInJava"
})
public final class AddCardViewModel_Factory implements Factory<AddCardViewModel> {
  @Override
  public AddCardViewModel get() {
    return newInstance();
  }

  public static AddCardViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AddCardViewModel newInstance() {
    return new AddCardViewModel();
  }

  private static final class InstanceHolder {
    private static final AddCardViewModel_Factory INSTANCE = new AddCardViewModel_Factory();
  }
}
