package marvelcomics.eoinahern.ie.marvelcomics.DI.Module;


import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelService;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelServiceInterceptor;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
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
	public Interceptor getInterceptor(@Named("public_key") String apikey) {
		return new MarvelServiceInterceptor(apikey);
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
	public String getURl() {
		return "https://gateway.marvel.com/";
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
	public MarvelService getRetrofit(@Named("url") String url, OkHttpClient okHttpClient) {

		return new Retrofit.Builder()
				.client(okHttpClient)
				.baseUrl(url)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build().create(MarvelService.class);
	}
}
