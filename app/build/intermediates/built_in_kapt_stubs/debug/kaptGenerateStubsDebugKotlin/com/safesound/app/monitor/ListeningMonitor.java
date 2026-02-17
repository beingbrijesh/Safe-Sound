package com.safesound.app.monitor;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 92\u00020\u0001:\u0003789B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u001c\u0010\u001e\u001a\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0082@\u00a2\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\u000e\u0010%\u001a\u00020\u001cH\u0082@\u00a2\u0006\u0002\u0010&J\u000e\u0010\'\u001a\u00020\u001cH\u0082@\u00a2\u0006\u0002\u0010&J\u000e\u0010(\u001a\u00020\u001cH\u0082@\u00a2\u0006\u0002\u0010&J\n\u0010)\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020.H\u0002J\u0016\u0010/\u001a\u00020!2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0012\u00100\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0012\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u000206H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001a\u00a8\u0006:"}, d2 = {"Lcom/safesound/app/monitor/ListeningMonitor;", "", "context", "Landroid/content/Context;", "listeningRepository", "Lcom/safesound/app/data/repo/ListeningRepository;", "<init>", "(Landroid/content/Context;Lcom/safesound/app/data/repo/ListeningRepository;)V", "audioManager", "Landroid/media/AudioManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeSession", "Lcom/safesound/app/monitor/ListeningMonitor$ActiveSession;", "currentDevice", "Lcom/safesound/app/data/model/DeviceState;", "playbackState", "Lcom/safesound/app/data/model/PlaybackInfo;", "samplingJob", "Lkotlinx/coroutines/Job;", "devicePollJob", "deviceCallback", "Landroid/media/AudioDeviceCallback;", "Landroid/media/AudioDeviceCallback;", "playbackCallback", "Landroid/media/AudioManager$AudioPlaybackCallback;", "Landroid/media/AudioManager$AudioPlaybackCallback;", "start", "", "stop", "handlePlaybackConfigs", "configs", "", "Landroid/media/AudioPlaybackConfiguration;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startSampling", "stopSampling", "sampleTick", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSessionIfActive", "updateDeviceState", "detectCurrentDevice", "resolveBluetoothAddress", "", "deviceName", "currentVolumeFraction", "", "selectPrimaryConfig", "resolveContentType", "attributes", "Landroid/media/AudioAttributes;", "resolveAppInfo", "Lcom/safesound/app/monitor/ListeningMonitor$AppInfo;", "uid", "", "AppInfo", "ActiveSession", "Companion", "app"})
public final class ListeningMonitor {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.repo.ListeningRepository listeningRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final android.media.AudioManager audioManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.Nullable()
    private com.safesound.app.monitor.ListeningMonitor.ActiveSession activeSession;
    @org.jetbrains.annotations.Nullable()
    private com.safesound.app.data.model.DeviceState currentDevice;
    @org.jetbrains.annotations.NotNull()
    private com.safesound.app.data.model.PlaybackInfo playbackState;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job samplingJob;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job devicePollJob;
    @org.jetbrains.annotations.NotNull()
    private final android.media.AudioDeviceCallback deviceCallback = null;
    @org.jetbrains.annotations.NotNull()
    private final android.media.AudioManager.AudioPlaybackCallback playbackCallback = null;
    private static final long SAMPLE_INTERVAL_MS = 3000L;
    private static final long DEVICE_POLL_INTERVAL_MS = 30000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.safesound.app.monitor.ListeningMonitor.Companion Companion = null;
    
    public ListeningMonitor(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.safesound.app.data.repo.ListeningRepository listeningRepository) {
        super();
    }
    
    public final void start() {
    }
    
    public final void stop() {
    }
    
    private final java.lang.Object handlePlaybackConfigs(java.util.List<android.media.AudioPlaybackConfiguration> configs, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void startSampling() {
    }
    
    private final void stopSampling() {
    }
    
    private final java.lang.Object sampleTick(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object endSessionIfActive(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object updateDeviceState(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.safesound.app.data.model.DeviceState detectCurrentDevice() {
        return null;
    }
    
    private final java.lang.String resolveBluetoothAddress(java.lang.String deviceName) {
        return null;
    }
    
    private final double currentVolumeFraction() {
        return 0.0;
    }
    
    private final android.media.AudioPlaybackConfiguration selectPrimaryConfig(java.util.List<android.media.AudioPlaybackConfiguration> configs) {
        return null;
    }
    
    private final java.lang.String resolveContentType(android.media.AudioAttributes attributes) {
        return null;
    }
    
    private final com.safesound.app.monitor.ListeningMonitor.AppInfo resolveAppInfo(int uid) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006&"}, d2 = {"Lcom/safesound/app/monitor/ListeningMonitor$ActiveSession;", "", "device", "Lcom/safesound/app/data/model/DeviceState;", "contentType", "", "sourceApp", "sourcePackage", "startTimeMillis", "", "volumes", "", "", "<init>", "(Lcom/safesound/app/data/model/DeviceState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getDevice", "()Lcom/safesound/app/data/model/DeviceState;", "getContentType", "()Ljava/lang/String;", "getSourceApp", "getSourcePackage", "getStartTimeMillis", "()J", "getVolumes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app"})
    static final class ActiveSession {
        @org.jetbrains.annotations.NotNull()
        private final com.safesound.app.data.model.DeviceState device = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String contentType = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String sourceApp = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String sourcePackage = null;
        private final long startTimeMillis = 0L;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.Double> volumes = null;
        
        public ActiveSession(@org.jetbrains.annotations.NotNull()
        com.safesound.app.data.model.DeviceState device, @org.jetbrains.annotations.Nullable()
        java.lang.String contentType, @org.jetbrains.annotations.Nullable()
        java.lang.String sourceApp, @org.jetbrains.annotations.Nullable()
        java.lang.String sourcePackage, long startTimeMillis, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.Double> volumes) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.safesound.app.data.model.DeviceState getDevice() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getContentType() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getSourceApp() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getSourcePackage() {
            return null;
        }
        
        public final long getStartTimeMillis() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.Double> getVolumes() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.safesound.app.data.model.DeviceState component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component4() {
            return null;
        }
        
        public final long component5() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.Double> component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.safesound.app.monitor.ListeningMonitor.ActiveSession copy(@org.jetbrains.annotations.NotNull()
        com.safesound.app.data.model.DeviceState device, @org.jetbrains.annotations.Nullable()
        java.lang.String contentType, @org.jetbrains.annotations.Nullable()
        java.lang.String sourceApp, @org.jetbrains.annotations.Nullable()
        java.lang.String sourcePackage, long startTimeMillis, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.Double> volumes) {
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
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/safesound/app/monitor/ListeningMonitor$AppInfo;", "", "packageName", "", "label", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"})
    static final class AppInfo {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String packageName = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String label = null;
        
        public AppInfo(@org.jetbrains.annotations.NotNull()
        java.lang.String packageName, @org.jetbrains.annotations.NotNull()
        java.lang.String label) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPackageName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLabel() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.safesound.app.monitor.ListeningMonitor.AppInfo copy(@org.jetbrains.annotations.NotNull()
        java.lang.String packageName, @org.jetbrains.annotations.NotNull()
        java.lang.String label) {
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
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/safesound/app/monitor/ListeningMonitor$Companion;", "", "<init>", "()V", "SAMPLE_INTERVAL_MS", "", "DEVICE_POLL_INTERVAL_MS", "app"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}