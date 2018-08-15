package top.buend.toolslibrary;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;

/**
 * Created by hdl
 */

public class AppMsgTools {


    /**
     * 获取app的版本号
     * @return 默认为0
     */
    public static int getVersionCode(){
        int versionCode = 0;
        try {
            versionCode = getPackageInfo().versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取app版本名称
     * @return 默认为空
     */
    public static String getVersionName(){
        String versionName = "";
        try {
            versionName = getPackageInfo().versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 获取应用包名
     * @return
     */
    public static String getPackageName(){
        return Tools.getAppContext().getPackageName();
    }

    /**
     * 获取应用名称
     * @return
     */
    public static String getAppName(){
        try {
            int labelRes = getPackageInfo().applicationInfo.labelRes;
            return Tools.getAppContext().getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return  null;
    }

    private static PackageInfo getPackageInfo() throws PackageManager.NameNotFoundException {
        return getPackageManager().getPackageInfo(getPackageName(),0);
    }

    private static PackageManager getPackageManager() {
        return Tools.getAppContext().getPackageManager();
    }






}
