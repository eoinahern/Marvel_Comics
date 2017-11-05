package marvelcomics.eoinahern.ie.marvelcomics.UI.Results;


import dagger.Module;
import dagger.Subcomponent;
import marvelcomics.eoinahern.ie.marvelcomics.DI.Component.BaseActivityComponent;
import marvelcomics.eoinahern.ie.marvelcomics.DI.Module.BaseActivityModule;
import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;


@PerScreen
@Subcomponent(modules = ResultsActivityComponent.ResultsActivityComponentModule.class)
public interface ResultsActivityComponent extends BaseActivityComponent<ResultsActivity> {

	@Module
	class ResultsActivityComponentModule extends BaseActivityModule<ResultsActivity> {

		public ResultsActivityComponentModule(ResultsActivity activity) {
			super(activity);
		}
	}
}
