package com.see99.hmvvm.model.http;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 网络接口
 */
public interface ApiService {

    //登录接口
    @POST("sa/login")
    Observable<HashMap<String,Object>> login(@Body HashMap<String, String> map );
}
