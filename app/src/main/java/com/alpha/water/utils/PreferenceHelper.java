package com.alpha.water.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Pascal dev on 2/17/2017.
 */

public class PreferenceHelper {

    private static final String PREFERENCE_NAME = "water";
    private static final String PREFERENCE_ANDROID_KEY = "android_key";
    private static final String PREFERENCE_EMAIL = "email";

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static String getAndroidKey(Context context) {
        return PreferenceHelper.getPreferences(context).getString(PREFERENCE_ANDROID_KEY, null);
    }

    public static void saveAndroidKey(Context context, String androidKey) {
        SharedPreferences.Editor prefs = PreferenceHelper.getPreferences(context).edit();
        prefs.putString(PREFERENCE_ANDROID_KEY, androidKey);
        prefs.apply();
    }

    public static String getUserMail(Context context) {
        return PreferenceHelper.getPreferences(context).getString(PREFERENCE_EMAIL, null);
    }

    public static void saveUserMail(Context context, String usermail) {
        SharedPreferences.Editor prefs = PreferenceHelper.getPreferences(context).edit();
        prefs.putString(PREFERENCE_EMAIL, usermail);
        prefs.apply();
    }

    public static void clearUser(Context context)
    {
        SharedPreferences.Editor prefs = PreferenceHelper.getPreferences(context).edit();
        prefs.remove(PREFERENCE_ANDROID_KEY);
        prefs.apply();
    }
}
