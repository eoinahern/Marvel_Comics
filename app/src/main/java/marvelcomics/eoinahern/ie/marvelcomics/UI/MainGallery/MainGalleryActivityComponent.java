package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import dagger.Module;
import dagger.Subcomponent;
import marvelcomics.eoinahern.ie.marvelcomics.DI.Component.BaseActivityComponent;
import marvelcomics.eoinahern.ie.marvelcomics.DI.Module.BaseActivityModule;
import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;


@PerScreen
@Subcomponent(modules =  MainGalleryActivityComponent.MainGalleryActivityModule.class)
public interface MainGalleryActivityComponent extends BaseActivityComponent<MainGalleryActivity> {

	@Module
	class MainGalleryActivityModule extends BaseActivityModule<MainGalleryActivity> {

		public MainGalleryActivityModule(MainGalleryActivity activity) {
			super(activity);
		}
	}
}
