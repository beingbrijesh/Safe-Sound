package com.safesound.app;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/safesound/app/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "listeningRepository", "Lcom/safesound/app/data/repo/ListeningRepository;", "specRepository", "Lcom/safesound/app/data/repo/SpecRepository;", "settingsRepository", "Lcom/safesound/app/data/repo/SettingsRepository;", "<init>", "(Lcom/safesound/app/data/repo/ListeningRepository;Lcom/safesound/app/data/repo/SpecRepository;Lcom/safesound/app/data/repo/SettingsRepository;)V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/safesound/app/MainUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "setAutoStartEnabled", "", "enabled", "", "Factory", "app"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.repo.ListeningRepository listeningRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.repo.SpecRepository specRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.repo.SettingsRepository settingsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.safesound.app.MainUiState> uiState = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.safesound.app.data.repo.ListeningRepository listeningRepository, @org.jetbrains.annotations.NotNull()
    com.safesound.app.data.repo.SpecRepository specRepository, @org.jetbrains.annotations.NotNull()
    com.safesound.app.data.repo.SettingsRepository settingsRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.safesound.app.MainUiState> getUiState() {
        return null;
    }
    
    public final void setAutoStartEnabled(boolean enabled) {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/safesound/app/MainViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "container", "Lcom/safesound/app/AppContainer;", "<init>", "(Lcom/safesound/app/AppContainer;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app"})
    public static final class Factory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull()
        private final com.safesound.app.AppContainer container = null;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        com.safesound.app.AppContainer container) {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass, @org.jetbrains.annotations.NotNull()
        androidx.lifecycle.viewmodel.CreationExtras extras) {
            return null;
        }
    }
}