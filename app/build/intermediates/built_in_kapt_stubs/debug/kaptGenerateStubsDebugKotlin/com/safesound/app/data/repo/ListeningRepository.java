package com.safesound.app.data.repo;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010#J\u0016\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\'J\u0018\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010+J\u001d\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/safesound/app/data/repo/ListeningRepository;", "", "listeningSessionDao", "Lcom/safesound/app/data/dao/ListeningSessionDao;", "deviceDao", "Lcom/safesound/app/data/dao/BluetoothDeviceDao;", "specRepository", "Lcom/safesound/app/data/repo/SpecRepository;", "settingsRepository", "Lcom/safesound/app/data/repo/SettingsRepository;", "historyMaintenanceDao", "Lcom/safesound/app/data/dao/HistoryMaintenanceDao;", "doseCalculator", "Lcom/safesound/app/util/DoseCalculator;", "volumeEstimator", "Lcom/safesound/app/util/VolumeEstimator;", "riskModel", "Lcom/safesound/app/ml/RiskModel;", "<init>", "(Lcom/safesound/app/data/dao/ListeningSessionDao;Lcom/safesound/app/data/dao/BluetoothDeviceDao;Lcom/safesound/app/data/repo/SpecRepository;Lcom/safesound/app/data/repo/SettingsRepository;Lcom/safesound/app/data/dao/HistoryMaintenanceDao;Lcom/safesound/app/util/DoseCalculator;Lcom/safesound/app/util/VolumeEstimator;Lcom/safesound/app/ml/RiskModel;)V", "observeCurrentDevice", "Lkotlinx/coroutines/flow/Flow;", "Lcom/safesound/app/data/model/DeviceState;", "observeTodayDosePercent", "", "observeTodayRiskPercent", "observePlaybackInfo", "Lcom/safesound/app/data/model/PlaybackInfo;", "recordSession", "", "session", "Lcom/safesound/app/data/model/ListeningSessionEntity;", "(Lcom/safesound/app/data/model/ListeningSessionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeviceState", "device", "(Lcom/safesound/app/data/model/DeviceState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveSpecsForDevice", "updatePlaybackInfo", "info", "(Lcom/safesound/app/data/model/PlaybackInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compactHistory", "", "daysToKeep", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "estimateDbFromVolume", "volumeFraction", "calibrationOffsetDb", "(DLjava/lang/Double;)D", "calculateDosePercent", "estimatedDb", "durationMinutes", "app"})
public final class ListeningRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.dao.ListeningSessionDao listeningSessionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.dao.BluetoothDeviceDao deviceDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.repo.SpecRepository specRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.repo.SettingsRepository settingsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.dao.HistoryMaintenanceDao historyMaintenanceDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.util.DoseCalculator doseCalculator = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.util.VolumeEstimator volumeEstimator = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.ml.RiskModel riskModel = null;
    
    public ListeningRepository(@org.jetbrains.annotations.NotNull()
    com.safesound.app.data.dao.ListeningSessionDao listeningSessionDao, @org.jetbrains.annotations.NotNull()
    com.safesound.app.data.dao.BluetoothDeviceDao deviceDao, @org.jetbrains.annotations.NotNull()
    com.safesound.app.data.repo.SpecRepository specRepository, @org.jetbrains.annotations.NotNull()
    com.safesound.app.data.repo.SettingsRepository settingsRepository, @org.jetbrains.annotations.NotNull()
    com.safesound.app.data.dao.HistoryMaintenanceDao historyMaintenanceDao, @org.jetbrains.annotations.NotNull()
    com.safesound.app.util.DoseCalculator doseCalculator, @org.jetbrains.annotations.NotNull()
    com.safesound.app.util.VolumeEstimator volumeEstimator, @org.jetbrains.annotations.NotNull()
    com.safesound.app.ml.RiskModel riskModel) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.safesound.app.data.model.DeviceState> observeCurrentDevice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> observeTodayDosePercent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> observeTodayRiskPercent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.safesound.app.data.model.PlaybackInfo> observePlaybackInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object recordSession(@org.jetbrains.annotations.NotNull()
    com.safesound.app.data.model.ListeningSessionEntity session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateDeviceState(@org.jetbrains.annotations.NotNull()
    com.safesound.app.data.model.DeviceState device, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object resolveSpecsForDevice(@org.jetbrains.annotations.NotNull()
    com.safesound.app.data.model.DeviceState device, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updatePlaybackInfo(@org.jetbrains.annotations.NotNull()
    com.safesound.app.data.model.PlaybackInfo info, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object compactHistory(int daysToKeep, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    public final double estimateDbFromVolume(double volumeFraction, @org.jetbrains.annotations.Nullable()
    java.lang.Double calibrationOffsetDb) {
        return 0.0;
    }
    
    public final double calculateDosePercent(double estimatedDb, double durationMinutes) {
        return 0.0;
    }
}