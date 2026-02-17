package com.safesound.app.data;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2 = {"Lcom/safesound/app/data/SafeSoundDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "earphoneSpecDao", "Lcom/safesound/app/data/dao/EarphoneSpecDao;", "deviceDao", "Lcom/safesound/app/data/dao/BluetoothDeviceDao;", "listeningSessionDao", "Lcom/safesound/app/data/dao/ListeningSessionDao;", "historyMaintenanceDao", "Lcom/safesound/app/data/dao/HistoryMaintenanceDao;", "Companion", "app"})
@androidx.room.Database(entities = {com.safesound.app.data.model.EarphoneSpecEntity.class, com.safesound.app.data.model.BluetoothDeviceEntity.class, com.safesound.app.data.model.ListeningSessionEntity.class, com.safesound.app.data.model.ListeningHistoryEntity.class}, version = 3)
public abstract class SafeSoundDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.safesound.app.data.SafeSoundDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.safesound.app.data.SafeSoundDatabase.Companion Companion = null;
    
    public SafeSoundDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.safesound.app.data.dao.EarphoneSpecDao earphoneSpecDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.safesound.app.data.dao.BluetoothDeviceDao deviceDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.safesound.app.data.dao.ListeningSessionDao listeningSessionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.safesound.app.data.dao.HistoryMaintenanceDao historyMaintenanceDao();
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/safesound/app/data/SafeSoundDatabase$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/safesound/app/data/SafeSoundDatabase;", "getInstance", "context", "Landroid/content/Context;", "app"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.safesound.app.data.SafeSoundDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}