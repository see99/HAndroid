package top.buend.androidtools;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.widget.Toast;

import top.buend.toolslibrary.Tools;

/**
 * Created by HDL
 * email:1066609543@qq.com hao3tian5@gmail.com
 * github:buend
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Tools.regist(this);
    }
}
