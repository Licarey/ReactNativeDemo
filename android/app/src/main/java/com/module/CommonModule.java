package com.module;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * Created by liming on 2018/4/18.
 * email liming@finupgroup.com
 */
public class CommonModule extends ReactContextBaseJavaModule {
    private ReactApplicationContext mContext;
    public static final String MODULE_NAME = "commModule";
    public static final String EVENT_NAME = "androidCallRn";

    /**
     * 构造方法必须实现
     *
     * @param reactContext
     */
    public CommonModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.mContext = reactContext;
    }

    /**
     * 在rn代码里面是需要这个名字来调用该类的方法
     *
     * @return
     */
    @Override
    public String getName() {
        return MODULE_NAME;
    }////这个名字在JavaScript端标记这个模块


    /**
     * Native调用RN
     *
     * @param msg
     */
    public void androidCallRn(String msg) {
        mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(EVENT_NAME, msg);
    }
}
