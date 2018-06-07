package com.packages;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.module.CommonModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liming on 2018/4/18.
 * email liming@finupgroup.com
 */
public class CommonPackage implements ReactPackage {
    public CommonModule mModule;

    /**
     * 创建Native Module
     * @param reactContext
     * @return
     */
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        mModule = new CommonModule(reactContext);
        modules.add(mModule);
        return modules;
    }

    public CommonModule getmModule() {
        return mModule;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}
