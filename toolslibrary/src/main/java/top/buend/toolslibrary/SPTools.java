package top.buend.toolslibrary;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.Map;
import java.util.Set;

/**
 * Created by HDL
 * email:1066609543@qq.com hao3tian5@gmail.com
 * github:buend
 */

public class SPTools {
    /**
     * default name packageName
     */
    private static final String dfName = Tools.getAppContext().getPackageName();

    private static String customName = null;

    public static String getDfName() {
        return dfName;
    }

    /**
     * 使用自定义sp文件时,必须调用这个方法
     * @param customName
     */
    public static void setCustomName(String customName) {
        SPTools.customName = customName;
    }

    public static String getCustomName() {
        return customName;
    }

    /**
     * 获取自定义sp
     * get custom sp
     * @return
     */
    private static SharedPreferences getSp(){
        if(TextUtils.isEmpty(customName)){
            throw new RuntimeException("setCustomName method must be called");
        }
        return Tools.getAppContext().getSharedPreferences(customName, Context.MODE_PRIVATE);
    }
    private static SharedPreferences.Editor getEditor(){
        return getSp().edit();
    }
    /**
     * 存放数据
     * @param key
     * @param value
     */
    public void put(String key, Object value){
        SharedPreferences.Editor editor = getEditor();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, (Set<String>) value);
        } else {
            throw new RuntimeException("Storage failure");
        }
        editor.commit();
    }


    public static String getString(String key, String df){
        return getSp().getString(key,df);
    }

    public static int getInt(String key,int df){
        return getSp().getInt(key,df);
    }

    public static long getLong(String key, long df){
        return getSp().getLong(key,df);
    }

    public static float getFloat(String key, float df){
        return getSp().getFloat(key,df);
    }

    public static boolean getBoolean(String key, boolean df){
        return getSp().getBoolean(key,df);
    }

    public static Set<String> getStringSet(String key, Set<String> df){
        return getSp().getStringSet(key,df);
    }

    /**
     * Remove value by key
     */
    public static void remove(String key){
        if(TextUtils.isEmpty(key)){
            throw new RuntimeException("key error");
        }
        getEditor().remove(key).commit();
    }

    public static boolean contain(String key){
        return getSp().contains(key);
    }

    public static Map<String,?> getAll(){
        return getSp().getAll();
    }

    //    ====================================DEFAULT==================================

    /**
     * 获取文件名为包名的 sp
     * get default SharedPreferences name of packageName
     * @return
     */
    private static SharedPreferences getDfSp(){
        return Tools.getAppContext().getSharedPreferences(dfName, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getDfEditor(){
        return getDfSp().edit();
    }

    /**
     * 存放数据
     * @param key
     * @param value
     */
    public void putByDf(String key, Object value){
        SharedPreferences.Editor editor = getDfEditor();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, (Set<String>) value);
        } else {
            throw new RuntimeException("Storage failure");
        }
        editor.commit();
    }

    public static String getStringByDf(String key, String df){
        return getDfSp().getString(key,df);
    }

    public static int getIntByDf(String key,int df){
        return getDfSp().getInt(key,df);
    }

    public static long getLongByDf(String key, long df){
        return getDfSp().getLong(key,df);
    }

    public static float getFloatByDf(String key, float df){
        return getDfSp().getFloat(key,df);
    }

    public static boolean getBooleanByDf(String key, boolean df){
        return getDfSp().getBoolean(key,df);
    }

    public static Set<String> getStringSetByDf(String key, Set<String> df){
        return getDfSp().getStringSet(key,df);
    }

    /**
     * Remove value by key
     */
    public static void removeByDf(String key){
        if(TextUtils.isEmpty(key)){
            throw new RuntimeException("key error");
        }
        getDfEditor().remove(key).commit();
    }

    public static boolean containByDf(String key){
        return getDfSp().contains(key);
    }

    public static Map<String,?> getAllByDf(){
        return getDfSp().getAll();
    }


}
