package marvelcomics.eoinahern.ie.marvelcomics;

import android.app.Application;
import android.content.Context;

import marvelcomics.eoinahern.ie.marvelcomics.DI.Component.ApplicationComponent;

public class App extends Application {

	private  ApplicationComponent appComponent;

	@Override
	public void onCreate() {
		super.onCreate();
	}

	public static App get(Context cont) {
		return (App) cont.getApplicationContext();
	}

	public  ApplicationComponent getComponent() {
		return appComponent;
	}
}
