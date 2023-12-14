package com.example.untitled;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.Map;

class NativeViewFactory extends PlatformViewFactory {

    NativeViewFactory() {
        super(StandardMessageCodec.INSTANCE);
    }

    @NonNull
    @Override
    public PlatformView create(@NonNull Context context, int id, @Nullable Object args) {
        final Map<String, Object> creationParams = (Map<String, Object>) args;
        return new NativeView(context, id, creationParams);
    }
}

//
//public class NativeViewFactory extends PlatformViewFactory {
//
//    public NativeViewFactory(StandardMessageCodec createArgsCodec) {
//        super(createArgsCodec);
//    }
//
//    @Override
//    public PlatformView create(Context context, int viewId, Object args) {
//        Map<String, Object> creationParams = (Map<String, Object>) args;
//        return new NativeView(context, viewId, creationParams);
//    }
//}