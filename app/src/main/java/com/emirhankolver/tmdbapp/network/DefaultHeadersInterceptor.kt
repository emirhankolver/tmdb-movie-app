package com.emirhankolver.tmdbapp.network

import com.emirhankolver.tmdbapp.common.AppConstants
import okhttp3.Interceptor
import okhttp3.Response

class DefaultHeadersInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()

        requestBuilder.header("Authorization", "Bearer ${AppConstants.API_TOKEN}")
        requestBuilder.header("Accept", "application/json")
        requestBuilder.method(request.method, request.body)

        return chain.proceed(requestBuilder.build())
    }
}