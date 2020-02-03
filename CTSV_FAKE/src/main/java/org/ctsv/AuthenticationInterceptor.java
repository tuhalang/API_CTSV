package org.ctsv;

import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class AuthenticationInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request().newBuilder().addHeader(ConstantsKt.API_SERVICE_AUTHENTICATION_NAME, "").build());
        return proceed;
    }
}
