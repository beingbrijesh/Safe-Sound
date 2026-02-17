package com.safesound.app.data.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\fH\'J\u0010\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\fH\'\u00a8\u0006\u000f\u00c0\u0006\u0003"}, d2 = {"Lcom/safesound/app/data/dao/BluetoothDeviceDao;", "", "get", "Lcom/safesound/app/data/model/BluetoothDeviceEntity;", "address", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsert", "", "device", "(Lcom/safesound/app/data/model/BluetoothDeviceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeDevice", "Lkotlinx/coroutines/flow/Flow;", "observeConnectedDevice", "observeMostRecentDevice", "app"})
@androidx.room.Dao()
public abstract interface BluetoothDeviceDao {
    
    @androidx.room.Query(value = "SELECT * FROM bluetooth_devices WHERE address = :address")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object get(@org.jetbrains.annotations.NotNull()
    java.lang.String address, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.safesound.app.data.model.BluetoothDeviceEntity> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
    com.safesound.app.data.model.BluetoothDeviceEntity device, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM bluetooth_devices WHERE address = :address")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.safesound.app.data.model.BluetoothDeviceEntity> observeDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String address);
    
    @androidx.room.Query(value = "SELECT * FROM bluetooth_devices WHERE isConnected = 1 ORDER BY lastSeenMillis DESC LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.safesound.app.data.model.BluetoothDeviceEntity> observeConnectedDevice();
    
    @androidx.room.Query(value = "SELECT * FROM bluetooth_devices ORDER BY lastSeenMillis DESC LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.safesound.app.data.model.BluetoothDeviceEntity> observeMostRecentDevice();
}