package com.safesound.app;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/safesound/app/AppContainer;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "database", "Lcom/safesound/app/data/SafeSoundDatabase;", "settingsRepository", "Lcom/safesound/app/data/repo/SettingsRepository;", "getSettingsRepository", "()Lcom/safesound/app/data/repo/SettingsRepository;", "specRemoteClient", "Lcom/safesound/app/network/SpecRemoteClient;", "specRepository", "Lcom/safesound/app/data/repo/SpecRepository;", "getSpecRepository", "()Lcom/safesound/app/data/repo/SpecRepository;", "doseCalculator", "Lcom/safesound/app/util/DoseCalculator;", "volumeEstimator", "Lcom/safesound/app/util/VolumeEstimator;", "riskModel", "Lcom/safesound/app/ml/RiskModel;", "listeningRepository", "Lcom/safesound/app/data/repo/ListeningRepository;", "getListeningRepository", "()Lcom/safesound/app/data/repo/ListeningRepository;", "app"})
public final class AppContainer {
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.SafeSoundDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.repo.SettingsRepository settingsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.network.SpecRemoteClient specRemoteClient = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.repo.SpecRepository specRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.util.DoseCalculator doseCalculator = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.util.VolumeEstimator volumeEstimator = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.ml.RiskModel riskModel = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.repo.ListeningRepository listeningRepository = null;
    
    public AppContainer(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.safesound.app.data.repo.SettingsRepository getSettingsRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.safesound.app.data.repo.SpecRepository getSpecRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.safesound.app.data.repo.ListeningRepository getListeningRepository() {
        return null;
    }
}