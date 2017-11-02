package marvelcomics.eoinahern.ie.marvelcomics;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.facebook.drawee.backends.pipeline.Fresco;

import marvelcomics.eoinahern.ie.marvelcomics.DI.Component.ApplicationComponent;
import marvelcomics.eoinahern.ie.marvelcomics.DI.Component.DaggerApplicationComponent;
import marvelcomics.eoinahern.ie.marvelcomics.DI.Module.ApplicationModule;

public class App extends MultiDexApplication {

	private  ApplicationComponent appComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		Fresco.initialize(this);
	}

	public static App get(Context cont) {
		return (App) cont.getApplicationContext();
	}

	public  ApplicationComponent getComponent() {

		if(appComponent == null) {
			appComponent = DaggerApplicationComponent.builder()
					.applicationModule(new ApplicationModule(this))
					.build();
		}

		return appComponent;
	}
}
