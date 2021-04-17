package top.buend.toolslibrary;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import androidx.annotation.RequiresPermission;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.Manifest.permission.ACCESS_WIFI_STATE;
import static android.Manifest.permission.CALL_PHONE;

public class PhoneTools {

    /**
     * 直接拨打电话
     * @param context
     * @param num
     */
    @RequiresPermission(CALL_PHONE)
    public static void call(Context context, String num) {
        // 先判断是否是数字
        Pattern pattern = Pattern.compile("^-?[0-9]+");
        Matcher isNum = pattern.matcher(num);
        if (!isNum.matches()) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + 10010);
        intent.setData(data);
        context.startActivity(intent);

    }


    /**
     * 跳转到拨号键页面  进行拨打
     * @param context
     * @param num
     */
    @RequiresPermission(CALL_PHONE)
    public static void callDial(Context context, String num) {
        // 先判断是否是数字
        Pattern pattern = Pattern.compile("^-?[0-9]+");
        Matcher isNum = pattern.matcher(num);
        if (!isNum.matches()) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + 10010);
        intent.setData(data);
        context.startActivity(intent);

    }

}



