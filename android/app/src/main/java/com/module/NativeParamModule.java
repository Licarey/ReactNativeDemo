package com.module;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

/**
 * Created by liming on 2018/4/18.
 * email liming@finupgroup.com
 */
public class NativeParamModule extends ReactContextBaseJavaModule {
    public NativeParamModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "NativeManageTest";
    }

    @ReactMethod
    public void getParam(Callback callback) {
        WritableMap map = new WritableNativeMap();
        map.putString("name", "NativeParamModule传来的参数");
        callback.invoke(map);
    }
}
