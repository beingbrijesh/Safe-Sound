package com.safesound.app.network;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/safesound/app/network/SpecRemoteClient;", "", "settingsRepository", "Lcom/safesound/app/data/repo/SettingsRepository;", "client", "Lokhttp3/OkHttpClient;", "<init>", "(Lcom/safesound/app/data/repo/SettingsRepository;Lokhttp3/OkHttpClient;)V", "getSettingsRepository", "()Lcom/safesound/app/data/repo/SettingsRepository;", "lookup", "Lcom/safesound/app/network/SpecResult;", "query", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseSpec", "json", "Lorg/json/JSONObject;", "app"})
public final class SpecRemoteClient {
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.repo.SettingsRepository settingsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.OkHttpClient client = null;
    
    public SpecRemoteClient(@org.jetbrains.annotations.NotNull()
    com.safesound.app.data.repo.SettingsRepository settingsRepository, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.safesound.app.data.repo.SettingsRepository getSettingsRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object lookup(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.safesound.app.network.SpecResult> $completion) {
        return null;
    }
    
    private final com.safesound.app.network.SpecResult parseSpec(org.json.JSONObject json) {
        return null;
    }
}