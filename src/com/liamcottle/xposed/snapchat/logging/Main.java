package com.liamcottle.xposed.snapchat.logging;

import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class Main implements IXposedHookLoadPackage {

    private static final String TAG = "SnapchatLogging";

    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {

        if(!lpparam.packageName.equals("com.snapchat.android")) {
            return;
        }

        XposedBridge.log("Loaded Package: com.snapchat.android");

        XC_MethodHook timberHook = new XC_MethodHook() {
            protected void beforeHookedMethod(MethodHookParam param) {
                String message = (String) param.args[1];
                Object[] vars = (Object[]) param.args[2];
                if (vars.length > 0) {
                    message = String.format(message, vars);
                }
                Log.d(TAG, "(" + param.args[0] + ") " + message);
            }
        };

        Class timberClass = XposedHelpers.findClass("com.snapchat.android.Timber", lpparam.classLoader);

        XposedHelpers.findAndHookMethod(timberClass, "a", String.class, String.class, Object[].class, timberHook);
        XposedHelpers.findAndHookMethod(timberClass, "b", String.class, String.class, Object[].class, timberHook);
        XposedHelpers.findAndHookMethod(timberClass, "c", String.class, String.class, Object[].class, timberHook);
        XposedHelpers.findAndHookMethod(timberClass, "d", String.class, String.class, Object[].class, timberHook);
        XposedHelpers.findAndHookMethod(timberClass, "e", String.class, String.class, Object[].class, timberHook);
        XposedHelpers.findAndHookMethod(timberClass, "f", String.class, String.class, Object[].class, timberHook);
        XposedHelpers.findAndHookMethod(timberClass, "g", String.class, String.class, Object[].class, timberHook);
        XposedHelpers.findAndHookMethod(timberClass, "h", String.class, String.class, Object[].class, timberHook);
        XposedHelpers.findAndHookMethod(timberClass, "i", String.class, String.class, Object[].class, timberHook);

    }

}
