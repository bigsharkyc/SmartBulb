package com.mod.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yangc on 2015/6/30.
 */
public class PreferenceUtil {
    private static final String PREF_NAME = "mod_config";
    private static final String FIRST_LOGIN = "first_login";
    private static final String LOGIN_USER_NAME = "login_user_name";
    private static final String LOGIN_USER_PWD = "login_user_pwd";
    private static final String KEEP_PWD = "keep_pwd";
    private static final String AUTO_LOGIN = "auto_login";


    private static SharedPreferences getSp(Context context){
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    private static SharedPreferences getSp(Context context, String name){
        return context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    /**
     * 设置app是否第一次启动加载viewPager
     * @param context
     * @param isFirst
     */
    public static void setFirstLogin(Context context, boolean isFirst){
        getSp(context, PREF_NAME).edit().putBoolean(FIRST_LOGIN, isFirst).commit();
    }

    public static boolean getFirstLogin(Context context){
        return getSp(context, PREF_NAME).getBoolean(FIRST_LOGIN, true);
    }

    /**
     * 保存用户名
     * @param context
     * @param value
     */
    public static void setLoginUserName(Context context, String value){
        getSp(context).edit().putString(LOGIN_USER_NAME, value).commit();
    }

    public static String getLoginUserName(Context context){
        return getSp(context).getString(LOGIN_USER_NAME, "");
    }

    /**
     * 保存密码
     * @param context
     * @param value
     */
    public static void setLoginUserPwd(Context context, String value){
        getSp(context).edit().putString(LOGIN_USER_PWD, value).commit();
    }

    public static String getLoginUserPwd(Context context){
        return getSp(context).getString(LOGIN_USER_PWD,"");
    }

    /**
     * 设置是否保存密码
     * @param context
     * @param value
     */
    public static void setIsKeepPwd(Context context, boolean value){
        getSp(context).edit().putBoolean(KEEP_PWD,value).commit();
    }

    public static boolean getIsKeepPwd(Context context){
        return  getSp(context).getBoolean(KEEP_PWD,false);
    }

    /**
     * 设置是否自动登录
     * @param context
     * @param value
     */
    public static void setIsAutoLogin(Context context, boolean value){
        getSp(context).edit().putBoolean(AUTO_LOGIN, value).commit();
    }

    public static  boolean getIsAutoLogin(Context context){
        return getSp(context).getBoolean(AUTO_LOGIN, false);
    }
}
