package top.buend.toolslibrary;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import java.util.Stack;

/**
 * Created by HDL
 * email:1066609543@qq.com hao3tian5@gmail.com
 * github:buend
 */

public class Tools {

    private static Application appInstace;
    private static final ActivityLifecycleCallbacksImpl ACTIVITY_LIFECYCLE = new ActivityLifecycleCallbacksImpl();

    /**
     * regist Tools & init
     * @param app
     */
    public static void regist(Application app){
        if(appInstace == null){
            appInstace = app;
            appInstace.registerActivityLifecycleCallbacks(ACTIVITY_LIFECYCLE);
        }

    }

    public static ActivityLifecycleCallbacksImpl getActivityLifecycle() {
        return ACTIVITY_LIFECYCLE;
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

        private static final Stack<Activity> acStack = new Stack<>();

        public  Stack<Activity> getAcStack() {
            return acStack;
        }

        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
                if(getCurrentActivity()!=null && getCurrentActivity().getClass().getSimpleName().equals(activity.getClass().getSimpleName())){
                    acStack.pop();
                    acStack.push(activity);
                }else {
                    acStack.push(activity);
            }

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
            acStack.remove(activity);
        }

        /**
         * Current Activity
         * @return
         */
        public Activity getCurrentActivity(){
            if(acStack.empty()){
                return null;
            }
            return acStack.peek();
        }
    }

}
