package marvelcomics.eoinahern.ie.marvelcomics.Data.api.api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MarvelServiceInterceptor implements Interceptor {

	private String apiKey;

	public MarvelServiceInterceptor(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {

		Request originalRequest = chain.request();
		HttpUrl originalHttpUrl = originalRequest.url();


		HttpUrl url = originalHttpUrl.newBuilder()
				.addQueryParameter("apikey", apiKey)
				.build();


		Request.Builder requestBuilder = originalRequest.newBuilder()
				.url(url);

		return chain.proceed(requestBuilder.build());
	}
}
