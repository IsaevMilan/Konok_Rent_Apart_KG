package com.airbnbclone.app.domain.entities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J\t\u0010$\u001a\u00020\u000bH\u00c6\u0003J\t\u0010%\u001a\u00020\rH\u00c6\u0003JG\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010\'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020\tH\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006+"}, d2 = {"Lcom/airbnbclone/app/domain/entities/Conversation;", "", "id", "", "otherUser", "Lcom/airbnbclone/app/domain/entities/User;", "lastMessage", "Lcom/airbnbclone/app/domain/entities/Message;", "unreadCount", "", "updatedAt", "", "isOnline", "", "(Ljava/lang/String;Lcom/airbnbclone/app/domain/entities/User;Lcom/airbnbclone/app/domain/entities/Message;IJZ)V", "getId", "()Ljava/lang/String;", "()Z", "getLastMessage", "()Lcom/airbnbclone/app/domain/entities/Message;", "setLastMessage", "(Lcom/airbnbclone/app/domain/entities/Message;)V", "getOtherUser", "()Lcom/airbnbclone/app/domain/entities/User;", "getUnreadCount", "()I", "setUnreadCount", "(I)V", "getUpdatedAt", "()J", "setUpdatedAt", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Conversation {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final com.airbnbclone.app.domain.entities.User otherUser = null;
    @org.jetbrains.annotations.Nullable()
    private com.airbnbclone.app.domain.entities.Message lastMessage;
    private int unreadCount;
    private long updatedAt;
    private final boolean isOnline = false;
    
    public Conversation(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.airbnbclone.app.domain.entities.User otherUser, @org.jetbrains.annotations.Nullable()
    com.airbnbclone.app.domain.entities.Message lastMessage, int unreadCount, long updatedAt, boolean isOnline) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.airbnbclone.app.domain.entities.User getOtherUser() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.airbnbclone.app.domain.entities.Message getLastMessage() {
        return null;
    }
    
    public final void setLastMessage(@org.jetbrains.annotations.Nullable()
    com.airbnbclone.app.domain.entities.Message p0) {
    }
    
    public final int getUnreadCount() {
        return 0;
    }
    
    public final void setUnreadCount(int p0) {
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    public final void setUpdatedAt(long p0) {
    }
    
    public final boolean isOnline() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.airbnbclone.app.domain.entities.User component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.airbnbclone.app.domain.entities.Message component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.airbnbclone.app.domain.entities.Conversation copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.airbnbclone.app.domain.entities.User otherUser, @org.jetbrains.annotations.Nullable()
    com.airbnbclone.app.domain.entities.Message lastMessage, int unreadCount, long updatedAt, boolean isOnline) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}