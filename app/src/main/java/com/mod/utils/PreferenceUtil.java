package com.mod.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yangc on 2015/6/30.
 */
public class PreferenceUtil {
    private static final String PREF_NAME = "mod_config";
    private static final String FIRST_LOGIN = "first_login";

    private static SharedPreferences getSp(Context context){
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    private static SharedPreferences getSp(Context context, String name){
        return context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public static void setFirstLogin(Context context, boolean isFirst){
        getSp(context, PREF_NAME).edit().putBoolean(FIRST_LOGIN, isFirst).commit();
    }

    public static boolean getFirstLogin(Context context){
        return getSp(context, PREF_NAME).getBoolean(FIRST_LOGIN, true);
    }
}
