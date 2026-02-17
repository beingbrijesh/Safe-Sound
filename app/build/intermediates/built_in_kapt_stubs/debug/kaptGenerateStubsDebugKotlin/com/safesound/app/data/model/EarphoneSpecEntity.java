package com.safesound.app.data.model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b0\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u0010\u00103\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u00104\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u00105\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u0010\u00106\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u0010\u00107\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u000b\u00108\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010:\u001a\u00020\u0013H\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u00ba\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\tH\u00c6\u0001\u00a2\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\u00132\b\u0010@\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010A\u001a\u00020\u000bH\u00d6\u0001J\t\u0010B\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0015\u0010\r\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b&\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\'\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b-\u0010\u001f\u00a8\u0006C"}, d2 = {"Lcom/safesound/app/data/model/EarphoneSpecEntity;", "", "id", "", "brand", "", "model", "displayName", "driverSizeMm", "", "frequencyLowHz", "", "frequencyHighHz", "impedanceOhm", "sensitivityDb", "powerMw", "sourceName", "sourceUrl", "verified", "", "lastFetchedMillis", "calibrationOffsetDb", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/Double;)V", "getId", "()J", "getBrand", "()Ljava/lang/String;", "getModel", "getDisplayName", "getDriverSizeMm", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFrequencyLowHz", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFrequencyHighHz", "getImpedanceOhm", "getSensitivityDb", "getPowerMw", "getSourceName", "getSourceUrl", "getVerified", "()Z", "getLastFetchedMillis", "getCalibrationOffsetDb", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/Double;)Lcom/safesound/app/data/model/EarphoneSpecEntity;", "equals", "other", "hashCode", "toString", "app"})
@androidx.room.Entity(tableName = "earphone_specs")
public final class EarphoneSpecEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String brand = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String model = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String displayName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double driverSizeMm = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer frequencyLowHz = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer frequencyHighHz = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double impedanceOhm = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double sensitivityDb = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double powerMw = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String sourceName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String sourceUrl = null;
    private final boolean verified = false;
    private final long lastFetchedMillis = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double calibrationOffsetDb = null;
    
    public EarphoneSpecEntity(long id, @org.jetbrains.annotations.Nullable()
    java.lang.String brand, @org.jetbrains.annotations.Nullable()
    java.lang.String model, @org.jetbrains.annotations.NotNull()
    java.lang.String displayName, @org.jetbrains.annotations.Nullable()
    java.lang.Double driverSizeMm, @org.jetbrains.annotations.Nullable()
    java.lang.Integer frequencyLowHz, @org.jetbrains.annotations.Nullable()
    java.lang.Integer frequencyHighHz, @org.jetbrains.annotations.Nullable()
    java.lang.Double impedanceOhm, @org.jetbrains.annotations.Nullable()
    java.lang.Double sensitivityDb, @org.jetbrains.annotations.Nullable()
    java.lang.Double powerMw, @org.jetbrains.annotations.Nullable()
    java.lang.String sourceName, @org.jetbrains.annotations.Nullable()
    java.lang.String sourceUrl, boolean verified, long lastFetchedMillis, @org.jetbrains.annotations.Nullable()
    java.lang.Double calibrationOffsetDb) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBrand() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getDriverSizeMm() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getFrequencyLowHz() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getFrequencyHighHz() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getImpedanceOhm() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getSensitivityDb() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getPowerMw() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSourceName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSourceUrl() {
        return null;
    }
    
    public final boolean getVerified() {
        return false;
    }
    
    public final long getLastFetchedMillis() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getCalibrationOffsetDb() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final long component14() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component15() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.safesound.app.data.model.EarphoneSpecEntity copy(long id, @org.jetbrains.annotations.Nullable()
    java.lang.String brand, @org.jetbrains.annotations.Nullable()
    java.lang.String model, @org.jetbrains.annotations.NotNull()
    java.lang.String displayName, @org.jetbrains.annotations.Nullable()
    java.lang.Double driverSizeMm, @org.jetbrains.annotations.Nullable()
    java.lang.Integer frequencyLowHz, @org.jetbrains.annotations.Nullable()
    java.lang.Integer frequencyHighHz, @org.jetbrains.annotations.Nullable()
    java.lang.Double impedanceOhm, @org.jetbrains.annotations.Nullable()
    java.lang.Double sensitivityDb, @org.jetbrains.annotations.Nullable()
    java.lang.Double powerMw, @org.jetbrains.annotations.Nullable()
    java.lang.String sourceName, @org.jetbrains.annotations.Nullable()
    java.lang.String sourceUrl, boolean verified, long lastFetchedMillis, @org.jetbrains.annotations.Nullable()
    java.lang.Double calibrationOffsetDb) {
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