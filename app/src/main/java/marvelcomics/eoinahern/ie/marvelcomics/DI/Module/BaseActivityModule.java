package marvelcomics.eoinahern.ie.marvelcomics.DI.Module;


import dagger.Module;
import dagger.Provides;
import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;

@Module
public abstract class BaseActivityModule<T extends BaseActivity> {

	private final T activity;

	public BaseActivityModule(T activity) {
		this.activity = activity;
	}

	@Provides
	@PerScreen
	public T getActivity() {
		return activity;
	}

}
