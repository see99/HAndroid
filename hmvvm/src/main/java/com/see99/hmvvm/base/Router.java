package com.see99.hmvvm.base;

import android.os.Bundle;

public class Router {
    private int routerId;
    private Bundle bundle;

    public  Router(int routerId,Bundle bundle){
        this.bundle = bundle;
        this.routerId = routerId;
    }

    public int getRouterId() {
        return routerId;
    }

    public void setRouterId(int routerId) {
        this.routerId = routerId;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
