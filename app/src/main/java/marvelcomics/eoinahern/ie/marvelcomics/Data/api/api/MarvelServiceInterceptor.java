package marvelcomics.eoinahern.ie.marvelcomics.Data.api.api;

import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MarvelServiceInterceptor implements Interceptor {

	private String publicApiKey;
	private String md5;

	private static final String amount = "100";

	public MarvelServiceInterceptor(String publicApiKey, String md5) {
		this.publicApiKey = publicApiKey;
		this.md5 = md5;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {

		Request originalRequest = chain.request();
		HttpUrl originalHttpUrl = originalRequest.url();

		HttpUrl url = originalHttpUrl.newBuilder()
				.addQueryParameter("apikey", publicApiKey)
				.addQueryParameter("ts", "1")
				.addQueryParameter("hash", md5)
				.addQueryParameter("limit", amount)
				.build();

			Request request = originalRequest.newBuilder()
					.url(url).build();

			Log.d("request", request.toString());

			return chain.proceed(request);
	}
}
