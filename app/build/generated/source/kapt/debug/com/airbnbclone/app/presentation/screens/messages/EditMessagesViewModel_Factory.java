package com.airbnbclone.app.presentation.screens.messages;

import com.airbnbclone.app.domain.repository.MessageRepository;
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
public final class EditMessagesViewModel_Factory implements Factory<EditMessagesViewModel> {
  private final Provider<MessageRepository> messageRepositoryProvider;

  public EditMessagesViewModel_Factory(Provider<MessageRepository> messageRepositoryProvider) {
    this.messageRepositoryProvider = messageRepositoryProvider;
  }

  @Override
  public EditMessagesViewModel get() {
    return newInstance(messageRepositoryProvider.get());
  }

  public static EditMessagesViewModel_Factory create(
      Provider<MessageRepository> messageRepositoryProvider) {
    return new EditMessagesViewModel_Factory(messageRepositoryProvider);
  }

  public static EditMessagesViewModel newInstance(MessageRepository messageRepository) {
    return new EditMessagesViewModel(messageRepository);
  }
}
