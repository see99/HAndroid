package top.buend.toolslibrary;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.RequiresPermission;

import static android.Manifest.permission.ACCESS_NETWORK_STATE;

/**
 * Created by HDL
 * email:1066609543@qq.com hao3tian5@gmail.com
 * github:buend
 */

public class NetTools {

    /**
     *  判断网络是否连接
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static boolean isNetConnected(){

        NetworkInfo netWorkInfo = getNetWorkInfo();
        return netWorkInfo!=null && netWorkInfo.isAvailable();
    }
    @RequiresPermission(ACCESS_NETWORK_STATE)
    private static NetworkInfo getNetWorkInfo(){
        ConnectivityManager systemService = (ConnectivityManager) Tools.getAppInstace().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return systemService.getActiveNetworkInfo();
    }
}
