package com.safesound.app.data.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0097@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\u0010\u00c0\u0006\u0003"}, d2 = {"Lcom/safesound/app/data/dao/HistoryMaintenanceDao;", "", "getSessionsBefore", "", "Lcom/safesound/app/data/model/ListeningSessionEntity;", "cutoff", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHistory", "", "entries", "Lcom/safesound/app/data/model/ListeningHistoryEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSessionsBefore", "", "compactOldSessions", "app"})
@androidx.room.Dao()
public abstract interface HistoryMaintenanceDao {
    
    @androidx.room.Query(value = "SELECT * FROM listening_sessions WHERE startTimeMillis < :cutoff")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSessionsBefore(long cutoff, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.safesound.app.data.model.ListeningSessionEntity>> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertHistory(@org.jetbrains.annotations.NotNull()
    java.util.List<com.safesound.app.data.model.ListeningHistoryEntity> entries, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM listening_sessions WHERE startTimeMillis < :cutoff")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSessionsBefore(long cutoff, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Transaction()
    @org.jetbrains.annotations.Nullable()
    public default java.lang.Object compactOldSessions(long cutoff, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @androidx.room.Transaction()
        @org.jetbrains.annotations.Nullable()
        @java.lang.Deprecated()
        public static java.lang.Object compactOldSessions(@org.jetbrains.annotations.NotNull()
        com.safesound.app.data.dao.HistoryMaintenanceDao $this, long cutoff, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
            return null;
        }
    }
}