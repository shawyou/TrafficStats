
package aidl.meizu.com.trafficstats.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.Set;

import aidl.meizu.com.trafficstats.common.Constants;

public class SharedPreferenceUtils {

    /**
     * @param @param context
     * @param @param keyPrefix
     * @param @param value 设定文件
     * @return void 返回类型
     * @throws
     * @Title: writeSthPreference
     * @Description: write String value into shared preference
     */
    public static void writeSthPreference(Context mContext, String key, String value) {
        if (null == mContext) {
            return;
        }
        SharedPreferences preferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * @param @param  context
     * @param @param  keyPrefix
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     * @Title: readSthPreference
     * @Description: read shared preference string value
     */
    public static String readSthPreference(Context mContext, String key) {
        if (null == mContext || TextUtils.isEmpty(key)) {
            return "";
        }
        SharedPreferences preferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        return preferences.getString(key, "");
    }

    /**
     * @param @param mContext
     * @param @param keyPrefix
     * @param @param value 设定文件
     * @return void 返回类型
     * @throws
     * @Title: writeSthPreference
     * @Description: write boolean value into shared preference
     */
    public static void writeSthPreference(Context mContext, String key, boolean value) {
        if (null == mContext) {
            return;
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * @param @param  context
     * @param @param  keyPrefix
     * @param @return 设定文件
     * @return boolean 返回类型
     * @throws
     * @Title: readSthPreferenceBoolean
     * @Description: read shared preference boolean value
     */
    public static boolean readSthPreferenceBoolean(Context mContext, String key) {
        if (null == mContext) {
            return false;
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    /**
     * @param @param  context
     * @param @param  keyPrefix
     * @param @return 设定文件
     * @return boolean 返回类型
     * @throws
     * @Title: readSthPreferenceBoolean
     * @Description: read shared preference boolean value
     */
    public static boolean readSthPreferenceBoolean(Context mContext, String key, boolean defaultValue) {
        if (null == mContext) {
            return false;
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    /**
     * @param @param mContext
     * @param @param keyPrefix
     * @param @param value 设定文件
     * @return void 返回类型
     * @throws
     * @Title: writeSthPreference
     * @Description: put long value
     */
    public static void writeSthPreference(Context mContext, String key, long value) {
        if (null == mContext) {
            return;
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * @param @param  mContext
     * @param @param  keyPrefix
     * @param @return 设定文件
     * @return long 返回类型
     * @throws
     * @Title: readSthPreferenceLong
     * @Description: get Long value
     */
    public static long readSthPreferenceLong(Context mContext, String key) {
        if (null == mContext) {
            return 0;
        }
        SharedPreferences preferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        return preferences.getLong(key, 0);
    }

    public static void writeSthPreferenceSet(Context mContext, String key, Set<String> values) {
        if (null == mContext) {
            return;
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet(key, values);
        editor.apply();
    }

    public static Set<String> readSthPreferenceSet(Context mContext, String key) {
        if (null == mContext) {
            return null;
        }
        SharedPreferences preferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        return preferences.getStringSet(key, null);
    }

    public static void writeSthPreferenceInt(Context mContext, String key, int value) {
        if (null == mContext) {
            return;
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int readSthPreferenceInt(Context mContext, String key) {
        if (null == mContext) {
            return 0;
        }
        SharedPreferences preferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        return preferences.getInt(key, 0);
    }

    public static int readSthPreferenceInt(Context mContext, String key, int defaultValue) {
        if (null == mContext) {
            return defaultValue;
        }
        SharedPreferences preferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        return preferences.getInt(key, defaultValue);
    }

    public static void removeSthPreference(Context mContext, String key) {
        if (null == mContext) {
            return;
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(
                Constants.PREFERENCES_CLIENT_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }
}
