package com.safesound.app.data.repo;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0019J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015J\u0016\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0015J\u0016\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001fH\u0086@\u00a2\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u000e\u0010\'\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/safesound/app/data/repo/SettingsRepository;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "firstSyncDoneKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "backendUrlKey", "", "lastSyncStatusKey", "autoStartEnabledKey", "playbackActiveKey", "playbackContentTypeKey", "playbackSourceAppKey", "playbackSourcePackageKey", "observeLastSyncStatus", "Lkotlinx/coroutines/flow/Flow;", "setLastSyncStatus", "", "status", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAutoStartEnabled", "setAutoStartEnabled", "enabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observePlaybackInfo", "Lcom/safesound/app/data/model/PlaybackInfo;", "setPlaybackInfo", "info", "(Lcom/safesound/app/data/model/PlaybackInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFirstSyncDone", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFirstSyncDone", "value", "getBackendUrl", "setBackendUrl", "url", "app"})
public final class SettingsRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> dataStore = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> firstSyncDoneKey = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> backendUrlKey = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> lastSyncStatusKey = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> autoStartEnabledKey = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> playbackActiveKey = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> playbackContentTypeKey = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> playbackSourceAppKey = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> playbackSourcePackageKey = null;
    
    public SettingsRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> observeLastSyncStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setLastSyncStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> observeAutoStartEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setAutoStartEnabled(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.safesound.app.data.model.PlaybackInfo> observePlaybackInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setPlaybackInfo(@org.jetbrains.annotations.NotNull()
    com.safesound.app.data.model.PlaybackInfo info, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isFirstSyncDone(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setFirstSyncDone(boolean value, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBackendUrl(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setBackendUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}