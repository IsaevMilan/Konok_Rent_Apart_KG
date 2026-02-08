package com.airbnbclone.app.domain.repository;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\u000eJB\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0019J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0019J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00a6@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u00a6@\u00a2\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u00062\u0006\u0010\'\u001a\u00020$H\u00a6@\u00a2\u0006\u0002\u0010%\u00a8\u0006(\u00c0\u0006\u0003"}, d2 = {"Lcom/airbnbclone/app/domain/repository/MessageRepository;", "", "getConversations", "", "Lcom/airbnbclone/app/domain/entities/Conversation;", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessages", "Lcom/airbnbclone/app/domain/repository/MessageResult;", "conversationId", "page", "", "limit", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessage", "Lcom/airbnbclone/app/domain/entities/Message;", "text", "type", "audioUrl", "imageUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConversation", "otherUserId", "listingId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchMessages", "Lcom/airbnbclone/app/domain/repository/MessageSearchResult;", "query", "deleteMessages", "", "messageIds", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsRead", "uploadAudio", "audioData", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadImage", "imageData", "app_debug"})
public abstract interface MessageRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getConversations(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.airbnbclone.app.domain.entities.Conversation>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, int page, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.repository.MessageResult> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, @org.jetbrains.annotations.Nullable()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String audioUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.entities.Message> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createConversation(@org.jetbrains.annotations.NotNull()
    java.lang.String otherUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String listingId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.airbnbclone.app.domain.entities.Conversation> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.airbnbclone.app.domain.repository.MessageSearchResult>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> messageIds, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markAsRead(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object uploadAudio(@org.jetbrains.annotations.NotNull()
    byte[] audioData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object uploadImage(@org.jetbrains.annotations.NotNull()
    byte[] imageData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}