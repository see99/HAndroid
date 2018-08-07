package top.buend.toolslibrary;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by HDL
 * email:1066609543@qq.com hao3tian5@gmail.com
 * github:buend
 */

public class Tools {

    private static Application appInstace;
    private static final Application.ActivityLifecycleCallbacks ACTIVITYLIFECYCLE = new ActivityLifecycleCallbacksImpl();

    /**
     * regist Tools & init
     * @param app
     */
    public static void regist(Application app){
        if(appInstace == null){
            appInstace = app;
            appInstace.registerActivityLifecycleCallbacks(ACTIVITYLIFECYCLE);
        }

    }

    /**
     * get ApplcationInstace
     * @return
     */
    public static Application getAppInstace(){
        if(appInstace == null){
            throw  new RuntimeException("in Application regist Tools");
        }
        return appInstace;
    }

    /**
     * get ApplicationContext
     * @return
     */
    public static Context getAppContext(){
        return appInstace.getApplicationContext();
    }

    static class ActivityLifecycleCallbacksImpl implements Application.ActivityLifecycleCallbacks{

        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    }

}
