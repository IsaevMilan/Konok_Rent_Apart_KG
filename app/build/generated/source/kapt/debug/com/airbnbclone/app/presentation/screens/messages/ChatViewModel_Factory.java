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
public final class ChatViewModel_Factory implements Factory<ChatViewModel> {
  private final Provider<MessageRepository> messageRepositoryProvider;

  public ChatViewModel_Factory(Provider<MessageRepository> messageRepositoryProvider) {
    this.messageRepositoryProvider = messageRepositoryProvider;
  }

  @Override
  public ChatViewModel get() {
    return newInstance(messageRepositoryProvider.get());
  }

  public static ChatViewModel_Factory create(
      Provider<MessageRepository> messageRepositoryProvider) {
    return new ChatViewModel_Factory(messageRepositoryProvider);
  }

  public static ChatViewModel newInstance(MessageRepository messageRepository) {
    return new ChatViewModel(messageRepository);
  }
}
