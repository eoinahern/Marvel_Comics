package marvelcomics.eoinahern.ie.marvelcomics.DI.Component;

import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;


public interface BaseActivityComponent<T extends BaseActivity> {
	void inject(T activity);
}
