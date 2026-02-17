package com.safesound.app.util;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000b"}, d2 = {"Lcom/safesound/app/util/BatteryOptimizationHelper;", "", "<init>", "()V", "isIgnoringBatteryOptimizations", "", "context", "Landroid/content/Context;", "buildRequestIntent", "Landroid/content/Intent;", "buildSettingsIntent", "app"})
public final class BatteryOptimizationHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.safesound.app.util.BatteryOptimizationHelper INSTANCE = null;
    
    private BatteryOptimizationHelper() {
        super();
    }
    
    public final boolean isIgnoringBatteryOptimizations(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Intent buildRequestIntent(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent buildSettingsIntent() {
        return null;
    }
}