package com.example.itcourses.data.api

import com.example.itcourses.data.model.TokenStore
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class BasicAuthInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val sessionToken : String = TokenStore.token

        var request = chain.request()

        if (sessionToken.isNotEmpty()) {
            request = request.newBuilder()
                .header("Authorization", "Bearer $sessionToken")
                .build()
        }

        return chain.proceed(request)
    }


}


