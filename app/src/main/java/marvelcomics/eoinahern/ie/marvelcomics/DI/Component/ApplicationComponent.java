package marvelcomics.eoinahern.ie.marvelcomics.DI.Component;

import javax.inject.Singleton;

import dagger.Component;
import marvelcomics.eoinahern.ie.marvelcomics.DI.Module.ApplicationModule;
import marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery.MainGalleryActivityComponent;
import marvelcomics.eoinahern.ie.marvelcomics.UI.Results.ResultsActivityComponent;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

	MainGalleryActivityComponent plus(MainGalleryActivityComponent.MainGalleryActivityModule module);

	ResultsActivityComponent plus(ResultsActivityComponent.ResultsActivityComponentModule module);
}
