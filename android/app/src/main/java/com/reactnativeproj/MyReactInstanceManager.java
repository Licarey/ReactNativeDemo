package com.reactnativeproj;

import android.app.Application;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.packages.CommonPackage;
import com.packages.ToastReactPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liming on 2018/4/18.
 * email liming@finupgroup.com
 */
public class MyReactInstanceManager {
    private static ReactInstanceManager sInstance = null;
    public static List<ReactPackage> packageList = new ArrayList<>();

    public static synchronized ReactInstanceManager getInstance() {
        if (sInstance == null) {
            packageList.add(new MainReactPackage());
            packageList.add(new ToastReactPackage());
            packageList.add(new CommonPackage());
            sInstance = ReactInstanceManager.builder()
                    .setApplication((Application) MainApplication.getContext())
                    .setBundleAssetName("index.android.bundle")
                    .setJSMainModulePath("reactjs/index")
                    .addPackages(packageList)
                    .setUseDeveloperSupport(BuildConfig.DEBUG)
                    .setInitialLifecycleState(LifecycleState.RESUMED)
                    .build();
        }
        return sInstance;
    }
}
