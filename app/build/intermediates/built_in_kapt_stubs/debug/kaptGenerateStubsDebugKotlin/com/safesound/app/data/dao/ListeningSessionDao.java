package com.safesound.app.data.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\'J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f\u00c0\u0006\u0003"}, d2 = {"Lcom/safesound/app/data/dao/ListeningSessionDao;", "", "insert", "", "session", "Lcom/safesound/app/data/model/ListeningSessionEntity;", "(Lcom/safesound/app/data/model/ListeningSessionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeSessions", "Lkotlinx/coroutines/flow/Flow;", "", "start", "", "end", "getSessions", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"})
@androidx.room.Dao()
public abstract interface ListeningSessionDao {
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.safesound.app.data.model.ListeningSessionEntity session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM listening_sessions WHERE startTimeMillis BETWEEN :start AND :end")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.safesound.app.data.model.ListeningSessionEntity>> observeSessions(long start, long end);
    
    @androidx.room.Query(value = "SELECT * FROM listening_sessions WHERE startTimeMillis BETWEEN :start AND :end")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSessions(long start, long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.safesound.app.data.model.ListeningSessionEntity>> $completion);
}