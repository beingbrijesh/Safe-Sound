package com.safesound.app.ml;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/safesound/app/ml/RiskModel;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "interpreter", "Lorg/tensorflow/lite/Interpreter;", "predictMultiplier", "", "features", "", "([F)Ljava/lang/Float;", "loadModelFile", "Ljava/nio/MappedByteBuffer;", "fileName", "", "Companion", "app"})
public final class RiskModel {
    @org.jetbrains.annotations.Nullable()
    private final org.tensorflow.lite.Interpreter interpreter = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MODEL_FILE = "safesound_risk.tflite";
    @org.jetbrains.annotations.NotNull()
    public static final com.safesound.app.ml.RiskModel.Companion Companion = null;
    
    public RiskModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float predictMultiplier(@org.jetbrains.annotations.NotNull()
    float[] features) {
        return null;
    }
    
    private final java.nio.MappedByteBuffer loadModelFile(android.content.Context context, java.lang.String fileName) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/safesound/app/ml/RiskModel$Companion;", "", "<init>", "()V", "MODEL_FILE", "", "app"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}