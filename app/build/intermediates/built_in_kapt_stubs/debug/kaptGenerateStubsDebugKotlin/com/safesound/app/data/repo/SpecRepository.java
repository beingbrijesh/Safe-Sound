package com.safesound.app.data.repo;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bJ\u0018\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/safesound/app/data/repo/SpecRepository;", "", "earphoneSpecDao", "Lcom/safesound/app/data/dao/EarphoneSpecDao;", "deviceDao", "Lcom/safesound/app/data/dao/BluetoothDeviceDao;", "remoteClient", "Lcom/safesound/app/network/SpecRemoteClient;", "<init>", "(Lcom/safesound/app/data/dao/EarphoneSpecDao;Lcom/safesound/app/data/dao/BluetoothDeviceDao;Lcom/safesound/app/network/SpecRemoteClient;)V", "observeSpecForDevice", "Lkotlinx/coroutines/flow/Flow;", "Lcom/safesound/app/data/model/EarphoneSpecEntity;", "address", "", "emptySpecFlow", "observeLastSyncStatus", "resolveAndCacheDevice", "device", "Lcom/safesound/app/data/model/DeviceState;", "(Lcom/safesound/app/data/model/DeviceState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"})
public final class SpecRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.dao.EarphoneSpecDao earphoneSpecDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.data.dao.BluetoothDeviceDao deviceDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.safesound.app.network.SpecRemoteClient remoteClient = null;
    
    public SpecRepository(@org.jetbrains.annotations.NotNull()
    com.safesound.app.data.dao.EarphoneSpecDao earphoneSpecDao, @org.jetbrains.annotations.NotNull()
    com.safesound.app.data.dao.BluetoothDeviceDao deviceDao, @org.jetbrains.annotations.NotNull()
    com.safesound.app.network.SpecRemoteClient remoteClient) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.safesound.app.data.model.EarphoneSpecEntity> observeSpecForDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String address) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.safesound.app.data.model.EarphoneSpecEntity> emptySpecFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> observeLastSyncStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object resolveAndCacheDevice(@org.jetbrains.annotations.NotNull()
    com.safesound.app.data.model.DeviceState device, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.safesound.app.data.model.EarphoneSpecEntity> $completion) {
        return null;
    }
}