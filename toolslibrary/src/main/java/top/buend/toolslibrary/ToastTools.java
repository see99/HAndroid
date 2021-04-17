package top.buend.toolslibrary;

import android.widget.Toast;

/**
 * Created by HDL
 * email:1066609543@qq.com hao3tian5@gmail.com
 * github:see99
 */

public class ToastTools {

    /**
     * toast
     * @param msg
     */
    public static void showToast(String msg){
        if (msg == null){
            throw  new RuntimeException("msg value is null");
        }
       Toast.makeText(Tools.getAppContext(),msg,Toast.LENGTH_LONG).show();
    }
}
