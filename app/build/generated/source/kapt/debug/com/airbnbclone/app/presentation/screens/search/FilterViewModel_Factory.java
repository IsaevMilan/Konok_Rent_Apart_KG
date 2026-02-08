package com.airbnbclone.app.presentation.screens.search;

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
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class FilterViewModel_Factory implements Factory<FilterViewModel> {
  @Override
  public FilterViewModel get() {
    return newInstance();
  }

  public static FilterViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FilterViewModel newInstance() {
    return new FilterViewModel();
  }

  private static final class InstanceHolder {
    static final FilterViewModel_Factory INSTANCE = new FilterViewModel_Factory();
  }
}
