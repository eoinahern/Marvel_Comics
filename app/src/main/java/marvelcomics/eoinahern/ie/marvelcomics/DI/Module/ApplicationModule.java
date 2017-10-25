package marvelcomics.eoinahern.ie.marvelcomics.DI.Module;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelService;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelServiceInterceptor;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.typeadapter.GsonAdapterFactory;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
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
	public OkHttpClient getClient(Interceptor interceptor) {
		return new OkHttpClient.Builder()
				.addInterceptor(interceptor)
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
