package com.alpha.water.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.alpha.water.activities.LoginActivity;

/**
 * Created by Pascal dev on 3/03/2017.
 */

public class NavigationUtils {

    public static void startActivity(Context context, Class activityClass)
    {
        Log.d("starting activity","starting activity");
        Intent intent = new Intent(context,activityClass);
        context.startActivity(intent);
    }

    public static void logOut(Context context)
    {
        PreferenceHelper.clearUser(context);
        Intent intent = LoginActivity.getIntent(context);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
