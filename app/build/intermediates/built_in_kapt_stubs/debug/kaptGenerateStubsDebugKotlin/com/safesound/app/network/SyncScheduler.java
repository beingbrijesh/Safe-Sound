package com.safesound.app.network;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ \u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/safesound/app/network/SyncScheduler;", "", "<init>", "()V", "FIRST_RUN_SYNC", "", "MANUAL_SYNC", "scheduleFirstRunSyncIfNeeded", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueueManualSync", "enqueueWork", "name", "policy", "Landroidx/work/ExistingWorkPolicy;", "app"})
public final class SyncScheduler {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FIRST_RUN_SYNC = "first_run_spec_sync";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String MANUAL_SYNC = "manual_spec_sync";
    @org.jetbrains.annotations.NotNull()
    public static final com.safesound.app.network.SyncScheduler INSTANCE = null;
    
    private SyncScheduler() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object scheduleFirstRunSyncIfNeeded(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object enqueueManualSync(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void enqueueWork(android.content.Context context, java.lang.String name, androidx.work.ExistingWorkPolicy policy) {
    }
}