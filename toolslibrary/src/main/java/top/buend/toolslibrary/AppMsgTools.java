package top.buend.toolslibrary;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by hdl
 */

public class AppMsgTools {


    /**
     * 获取app的版本号
     * @param mContext
     * @return 默认为0
     */
    public static int getVersionCode(){
        int versionCode = 0;
        try {
            versionCode = Tools.getAppContext().getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取app版本名称
     * @param mContext
     * @return 默认为空
     */
    public static String getVersionName(){
        String versionName = "";
        try {
            versionName = Tools.getAppContext().getPackageManager().getPackageInfo(getPackageName(),0).versionName;
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



}
