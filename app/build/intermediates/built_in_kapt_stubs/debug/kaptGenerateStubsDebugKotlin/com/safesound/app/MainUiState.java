package com.safesound.app;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\"\u001a\u00020\nH\u00c6\u0003J\t\u0010#\u001a\u00020\fH\u00c6\u0003J\t\u0010$\u001a\u00020\u000eH\u00c6\u0003JS\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010&\u001a\u00020\f2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020)H\u00d6\u0001J\t\u0010*\u001a\u00020\nH\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006+"}, d2 = {"Lcom/safesound/app/MainUiState;", "", "currentDevice", "Lcom/safesound/app/data/model/DeviceState;", "currentSpec", "Lcom/safesound/app/data/model/EarphoneSpecEntity;", "todayDosePercent", "", "todayRiskPercent", "lastSyncStatus", "", "autoStartEnabled", "", "playbackInfo", "Lcom/safesound/app/data/model/PlaybackInfo;", "<init>", "(Lcom/safesound/app/data/model/DeviceState;Lcom/safesound/app/data/model/EarphoneSpecEntity;DDLjava/lang/String;ZLcom/safesound/app/data/model/PlaybackInfo;)V", "getCurrentDevice", "()Lcom/safesound/app/data/model/DeviceState;", "getCurrentSpec", "()Lcom/safesound/app/data/model/EarphoneSpecEntity;", "getTodayDosePercent", "()D", "getTodayRiskPercent", "getLastSyncStatus", "()Ljava/lang/String;", "getAutoStartEnabled", "()Z", "getPlaybackInfo", "()Lcom/safesound/app/data/model/PlaybackInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app"})
public final class MainUiState {
    @org.jetbrains.annotations.Nullable()
    private final com.safesound.app.data.model.DeviceState currentDevice = null;
    @org.jetbrains.annotations.Nullable()
    private final com.safesound.app.data.model.EarphoneSpecEntity currentSpec = null;
    private final double todayDosePercent = 0.0;
    private final double todayRiskPercent = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String lastSyncStatus = null;
    private final boolean autoStartEnabled = false;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.model.PlaybackInfo playbackInfo = null;
    
    public MainUiState(@org.jetbrains.annotations.Nullable()
    com.safesound.app.data.model.DeviceState currentDevice, @org.jetbrains.annotations.Nullable()
    com.safesound.app.data.model.EarphoneSpecEntity currentSpec, double todayDosePercent, double todayRiskPercent, @org.jetbrains.annotations.NotNull()
    java.lang.String lastSyncStatus, boolean autoStartEnabled, @org.jetbrains.annotations.NotNull()
    com.safesound.app.data.model.PlaybackInfo playbackInfo) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.safesound.app.data.model.DeviceState getCurrentDevice() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.safesound.app.data.model.EarphoneSpecEntity getCurrentSpec() {
        return null;
    }
    
    public final double getTodayDosePercent() {
        return 0.0;
    }
    
    public final double getTodayRiskPercent() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastSyncStatus() {
        return null;
    }
    
    public final boolean getAutoStartEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.safesound.app.data.model.PlaybackInfo getPlaybackInfo() {
        return null;
    }
    
    public MainUiState() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.safesound.app.data.model.DeviceState component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.safesound.app.data.model.EarphoneSpecEntity component2() {
        return null;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.safesound.app.data.model.PlaybackInfo component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.safesound.app.MainUiState copy(@org.jetbrains.annotations.Nullable()
    com.safesound.app.data.model.DeviceState currentDevice, @org.jetbrains.annotations.Nullable()
    com.safesound.app.data.model.EarphoneSpecEntity currentSpec, double todayDosePercent, double todayRiskPercent, @org.jetbrains.annotations.NotNull()
    java.lang.String lastSyncStatus, boolean autoStartEnabled, @org.jetbrains.annotations.NotNull()
    com.safesound.app.data.model.PlaybackInfo playbackInfo) {
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