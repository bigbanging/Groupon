package com.litte.groupon.SPUtil;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static com.litte.groupon.contant.IContant.FIRST;

/**
 * 偏好设置的方法封装
 * 1）Context 的getSharePreference（文件名，模式）
 * 2）Activity的getSharePreference（模式）存储在以preference_activity名的文件中
 * 3）PreferenceManager的getDefaultPreferences
 *          将偏好文件存储在以preference_包名的文件中
 *          Context_MODE_PRIVATE
 * Created by litte on 2018/1/15.
 */

public class SPUtil {
    SharedPreferences sharedPreferences;
    //通过构造器重载，以同的方式来获得偏好设置
    public SPUtil(Context context){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
    /**
     *
     * @param context
     * @param name 偏好保存的文件名
     */
    public SPUtil(Context context,String name){
        sharedPreferences = context.getSharedPreferences(FIRST, Context.MODE_PRIVATE);
    }
    public boolean isFirst(){
        return sharedPreferences.getBoolean(FIRST,true);
    }
    public void setFirst(boolean flag){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(FIRST,false);
        editor.commit();
    }

}
