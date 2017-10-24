package marvelcomics.eoinahern.ie.marvelcomics.Data.api.api;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

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

		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("MD5", "1" + "5de1fabcda2ea08912bd8b09bca4321f50563655" + apiKey);

			HttpUrl url = originalHttpUrl.newBuilder()
				.addQueryParameter("apikey", apiKey)
				.addQueryParameter("ts", "1")
				.addQueryParameter("hash", md.toString())
				.build();

			Request.Builder requestBuilder = originalRequest.newBuilder()
					.url(url);

			return chain.proceed(requestBuilder.build());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}

		return null;
	}
}
