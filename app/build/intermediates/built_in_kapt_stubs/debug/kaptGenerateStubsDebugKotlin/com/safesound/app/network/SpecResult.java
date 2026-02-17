package com.safesound.app.network;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\'\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010(\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010*\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0010H\u00c6\u0003J\u0090\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001\u00a2\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\bH\u00d6\u0001J\t\u00104\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001d\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u00a8\u00065"}, d2 = {"Lcom/safesound/app/network/SpecResult;", "", "brand", "", "model", "driverSizeMm", "", "frequencyLowHz", "", "frequencyHighHz", "impedanceOhm", "sensitivityDb", "powerMw", "sourceName", "sourceUrl", "verified", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Z)V", "getBrand", "()Ljava/lang/String;", "getModel", "getDriverSizeMm", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFrequencyLowHz", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFrequencyHighHz", "getImpedanceOhm", "getSensitivityDb", "getPowerMw", "getSourceName", "getSourceUrl", "getVerified", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Z)Lcom/safesound/app/network/SpecResult;", "equals", "other", "hashCode", "toString", "app"})
public final class SpecResult {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String brand = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String model = null;
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
    
    public SpecResult(@org.jetbrains.annotations.Nullable()
    java.lang.String brand, @org.jetbrains.annotations.Nullable()
    java.lang.String model, @org.jetbrains.annotations.Nullable()
    java.lang.Double driverSizeMm, @org.jetbrains.annotations.Nullable()
    java.lang.Integer frequencyLowHz, @org.jetbrains.annotations.Nullable()
    java.lang.Integer frequencyHighHz, @org.jetbrains.annotations.Nullable()
    java.lang.Double impedanceOhm, @org.jetbrains.annotations.Nullable()
    java.lang.Double sensitivityDb, @org.jetbrains.annotations.Nullable()
    java.lang.Double powerMw, @org.jetbrains.annotations.Nullable()
    java.lang.String sourceName, @org.jetbrains.annotations.Nullable()
    java.lang.String sourceUrl, boolean verified) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBrand() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getModel() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.safesound.app.network.SpecResult copy(@org.jetbrains.annotations.Nullable()
    java.lang.String brand, @org.jetbrains.annotations.Nullable()
    java.lang.String model, @org.jetbrains.annotations.Nullable()
    java.lang.Double driverSizeMm, @org.jetbrains.annotations.Nullable()
    java.lang.Integer frequencyLowHz, @org.jetbrains.annotations.Nullable()
    java.lang.Integer frequencyHighHz, @org.jetbrains.annotations.Nullable()
    java.lang.Double impedanceOhm, @org.jetbrains.annotations.Nullable()
    java.lang.Double sensitivityDb, @org.jetbrains.annotations.Nullable()
    java.lang.Double powerMw, @org.jetbrains.annotations.Nullable()
    java.lang.String sourceName, @org.jetbrains.annotations.Nullable()
    java.lang.String sourceUrl, boolean verified) {
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