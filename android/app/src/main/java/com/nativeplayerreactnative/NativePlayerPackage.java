package com.nativeplayerreactnative;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.annotation.Nonnull;

public class NativePlayerPackage implements ReactPackage {

    @Nonnull
    @Override
    public List<NativeModule> createNativeModules(@Nonnull ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList(new NativePlayerModule(reactContext));
    }

    @Nonnull
    @Override
    public List<ViewManager> createViewManagers(@Nonnull ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}