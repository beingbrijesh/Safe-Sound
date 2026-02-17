package com.safesound.app.util;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\f"}, d2 = {"Lcom/safesound/app/util/PermissionHelper;", "", "<init>", "()V", "hasPermission", "", "context", "Landroid/content/Context;", "permission", "", "getMissingPermissions", "", "app"})
public final class PermissionHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.safesound.app.util.PermissionHelper INSTANCE = null;
    
    private PermissionHelper() {
        super();
    }
    
    public final boolean hasPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getMissingPermissions(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}