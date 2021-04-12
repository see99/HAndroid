package com.see99.hmvvm.model.http.interceptor

import android.util.Log
import okhttp3.*
import okio.Buffer
import java.io.IOException
import java.nio.charset.Charset
import java.util.*


/**
 * 作者 王亚鹏
 * 类说明{Log拦截器}
 */
class LogInterceptor : Interceptor {
    private val TAG = "okhttp"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        Log.e(TAG, "request:$request")

        val requestBody = request.body()
        requestBody?.let {
            val buffer = Buffer()
            requestBody!!.writeTo(buffer)
            var charset: Charset = Charset.forName("UTF-8")
            val contentType: MediaType? = it.contentType()
            if(contentType!=null){

            }
            val paramsStr: String = buffer.readString(charset)
            Log.e(TAG, "requestbody:${paramsStr}  personCode: ${request.header("personCode")}")


        }



        val t1 = System.nanoTime()
        val response = chain.proceed(chain.request())
        val t2 = System.nanoTime()
        Log.e(
                TAG, String.format(
                Locale.getDefault(),
                "Received response for %s in %.1fms%n%s",
                response.request().url(),
                (t2 - t1) / 1e6,
                request.body(),
                response.headers()
        )
        )

        if ("POST" == request.method()) {
            val sb = StringBuilder()
            if (request.body() is FormBody) {
                val body = request.body() as FormBody?
                for (i in 0 until body!!.size()) {
                    sb.append(body!!.encodedName(i) + "=" + body!!.encodedValue(i) + ",")
                }
                sb.delete(sb.length - 1, sb.length)
                Log.d(TAG, "| RequestParams:{$sb}")
            }
        }


        val mediaType = response.body()!!.contentType()
        val content = response.body()!!.string()
        Log.e(TAG, "response body:$content")
        return response.newBuilder()
            .body(ResponseBody.create(mediaType, content))
            .build()
    }
}