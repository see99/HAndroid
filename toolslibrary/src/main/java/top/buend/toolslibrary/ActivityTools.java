package top.buend.toolslibrary;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.Nullable;

import java.util.Stack;

/**
 * Created by HDL
 * email:1066609543@qq.com hao3tian5@gmail.com
 * github:buend
 */

public class ActivityTools {

    /**
     * 关闭所有Acitivity
     */
    public static void closeAllActivity() {
        Stack<Activity> acStack = Tools.getActivityLifecycle().getAcStack();
        while (acStack.size() > 0) {
            acStack.pop().finish();
        }
    }

}
