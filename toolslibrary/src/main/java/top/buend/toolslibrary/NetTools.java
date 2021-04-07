package top.buend.toolslibrary;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import androidx.annotation.RequiresPermission;

import java.io.IOException;

import static android.Manifest.permission.ACCESS_NETWORK_STATE;
import static android.Manifest.permission.ACCESS_WIFI_STATE;
import static android.content.Context.WIFI_SERVICE;

/**
 * Created by HDL
 * email:1066609543@qq.com hao3tian5@gmail.com
 * github:buend
 */

public class NetTools {

    /**
     * 判断移动网是否可用
     * @return
     * GPRS is connection
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static boolean isGPRSConnection(){
        NetworkInfo networkInfo = getConnectivityManager().getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return networkInfo!=null && networkInfo.isConnectedOrConnecting();
    }

    /**
     * wifi 是否可用
     * @return
     * wifi is connection
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static boolean isWifiConnection(){
        NetworkInfo networkInfo = getConnectivityManager().getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return networkInfo!=null && networkInfo.isConnectedOrConnecting();
    }

    /**
     * 判断网络是否连接
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static boolean isNetConnected() {

        NetworkInfo netWorkInfo = getNetWorkInfo();
        return netWorkInfo != null && netWorkInfo.isAvailable();
    }

    /**
     * 判断网络是否可用 通过ping
     *
     * @return network is available using ping
     */
    @RequiresPermission(anyOf = {ACCESS_NETWORK_STATE, ACCESS_NETWORK_STATE})
    public static boolean isAvailable(String ip) {

        if (ip == null) {
            return false;
        }
        String result = null;
        try {
            Process p = Runtime.getRuntime().exec("ping -c 1 " + ip);
            int status = p.waitFor();
            //process.waitFor() 返回0,当前网络可用  返回1,需要网页认证的wifi 返回2,当前网络不可以用
            if (status == 0) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 判断网络时否可用  6.0以上是通过新的api 6.0以下是通过ping来实现
     * @return
     */
    @RequiresPermission(anyOf = {ACCESS_NETWORK_STATE, ACCESS_NETWORK_STATE})
    public static boolean isAvailable() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            NetworkCapabilities networkCapabilities = getConnectivityManager().getNetworkCapabilities(getConnectivityManager().getActiveNetwork());
            return networkCapabilities.hasCapability(networkCapabilities.NET_CAPABILITY_VALIDATED);
        }
        return  isAvailable("58.217.200.112");
    }

    /**
     * 打开网络设置
     * open network setting
     */
    public static void openNetworkSettion() {
        Tools.getAppContext().startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     *
     * @return
     */
    @RequiresPermission(ACCESS_WIFI_STATE)
    public static boolean getWifiEnabled() {
        WifiManager manager = (WifiManager) Tools.getAppInstace().getApplicationContext().getSystemService(WIFI_SERVICE);
        return manager != null && manager.isWifiEnabled();
    }


    @RequiresPermission(ACCESS_NETWORK_STATE)
    private static NetworkInfo getNetWorkInfo() {
        ConnectivityManager systemService = getConnectivityManager();
        return systemService.getActiveNetworkInfo();
    }

    private static ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) Tools.getAppInstace().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    }

}
