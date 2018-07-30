package top.buend.toolslibrary;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by hdl
 */

public class APPTools {


    /**
     * 获取app的版本号
     * @param mContext
     * @return 默认为0
     */
    public static int getVersionCode(Context mContext){
        int versionCode = 0;
        try {
            versionCode = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionCode;
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
    public static String getVersionName(Context mContext){
        String versionName = "";
        try {
            versionName = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(),0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }


}
