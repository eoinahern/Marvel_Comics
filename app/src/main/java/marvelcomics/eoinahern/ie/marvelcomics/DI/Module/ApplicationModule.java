package marvelcomics.eoinahern.ie.marvelcomics.DI.Module;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.ResponseCacheInterceptor;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelService;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelServiceInterceptor;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.typeadapter.GsonAdapterFactory;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.util.NetworkUtil;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

	private final Application app;

	public ApplicationModule(Application app) {
		this.app = app;
	}

	@Provides
	@Singleton
	public Context appContext() {
		return app;
	}


	@Provides
	@Singleton
	@Named("md5")
	public String getMD5(@Named("public_key") String pubKey, @Named("private_key") String privKey) {

		String hash = "";

		try {

			MessageDigest md5 = MessageDigest.getInstance("MD5");
			String combinedStr = "1" + privKey + pubKey;

			md5.update(combinedStr.getBytes(), 0, combinedStr.length());
			hash = new BigInteger(1, md5.digest()).toString(16);
			Log.d("hash", hash);
			return hash;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hash;
	}

	@Provides
	@Singleton
	public Interceptor getInterceptor(@Named("public_key") String apikey, @Named("md5") String md5) {
		return new MarvelServiceInterceptor(apikey, md5);
	}

	@Provides
	@Singleton
	public NetworkUtil getNetworkUtil(Context context) {
		return new NetworkUtil(context);
	}


	@Provides
	@Singleton
	public OkHttpClient getClient(Interceptor interceptor, Context cont, NetworkUtil networkUtil) {
		return new OkHttpClient.Builder()
				.addInterceptor(interceptor)
				.addInterceptor((chain) -> {

					Request req = chain.request();

					if (!networkUtil.isConnected()) {
						req = req.newBuilder()
								.header("Cache-Control", "public, only-if-cached")
								.build();
					}

					return chain.proceed(req);
				})
				.addNetworkInterceptor(new ResponseCacheInterceptor())
				.cache(new Cache(new File(cont.getCacheDir(), "http-cache"), 10 * 1024 * 1024))
				.build();
	}

	@Provides
	@Singleton
	@Named("url")
	public HttpUrl getURl() {
		return HttpUrl.parse("http://gateway.marvel.com/");
	}

	@Provides
	@Singleton
	@Named("public_key")
	public String publicKey() {
		return "54306733de0f5cd1418aa05a85fa062a";
	}

	@Provides
	@Singleton
	@Named("private_key")
	public String privateKey() {
		return "5de1fabcda2ea08912bd8b09bca4321f50563655";
	}

	@Provides
	@Singleton
	public Gson gson() {

		return new GsonBuilder()
				.registerTypeAdapterFactory(GsonAdapterFactory.create())
				.setLenient()
				.create();
	}

	@Provides
	@Singleton
	public MarvelService getRetrofit(@Named("url") HttpUrl url, OkHttpClient okHttpClient, Gson gson) {

		return new Retrofit.Builder()
				.client(okHttpClient)
				.baseUrl(url)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build().create(MarvelService.class);
	}
}
