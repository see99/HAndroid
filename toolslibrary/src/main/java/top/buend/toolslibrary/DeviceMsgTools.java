package top.buend.toolslibrary;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

import static android.Manifest.permission.ACCESS_WIFI_STATE;
import static android.Manifest.permission.READ_PHONE_STATE;

/**
 * Created by HDL
 * email:1066609543@qq.com hao3tian5@gmail.com
 * github:buend
 */

public class DeviceMsgTools {


    /**
     * 获取 Serial Number 设备序列号
     * @return
     */
    public static String getSN(){
        return Build.SERIAL;
    }

    /**
     * get AndroidId  一般视为不可靠数据
     * @return
     */
    public static String getAndroidId(){
        return Settings.System.getString(Tools.getAppContext().getContentResolver(), Settings.System.ANDROID_ID);

    }

    /**
     * 获取IMEI  有的机型获取值为空
     * 6.0+ 需要检查权限
     * @return
     */
    @SuppressLint("MissingPermission")
    @RequiresPermission(READ_PHONE_STATE)
    public static String getIMEI() {

        TelephonyManager telephonyManager = (TelephonyManager) Tools.getAppInstace().getSystemService(Context.TELEPHONY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return telephonyManager != null ? telephonyManager.getImei() : "";
        }
        return telephonyManager != null ? telephonyManager.getDeviceId() : "";
    }



    /**
     * 判断是否是手机
     * @return
     */
    public static boolean isPhone(){

        return false;
    }

    /**
     * 获取mac地址
     * @return mac address
     * Android 6.0+ return 02:00:00:00:00:00
     */
    @RequiresPermission(ACCESS_WIFI_STATE)
    public static String getMac(){
        @SuppressLint("WifiManagerLeak")
        WifiManager wifiManager = (WifiManager) Tools.getAppInstace().getSystemService(Context.WIFI_SERVICE);
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        return connectionInfo.getMacAddress();
    }
}
