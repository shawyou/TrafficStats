package aidl.meizu.com.trafficstats.model;

import android.graphics.drawable.Drawable;

/**
 * Created by linshaoyou on 16/2/3.
 * app 的相关信息
 */
public class AppInfo {
    public String appName;
    public String packageName;
    public String versionName;
    public int versionCode;
    public Drawable appIcon;
    public int uid;

    @Override
    public String toString() {
        return "appName == " + appName
                + "\npackageName == " + packageName
                + "\nversionName == " + versionName
                + "\nversionCode == " + versionCode
                + "\nuid == " + uid;

    }
}
