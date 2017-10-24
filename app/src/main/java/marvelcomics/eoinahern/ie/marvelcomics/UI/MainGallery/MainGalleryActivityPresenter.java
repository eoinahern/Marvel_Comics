package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelService;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.BaseDisposableObserver;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery.GetMainGalleryInteractor;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BasePresenter;

@PerScreen
public class MainGalleryActivityPresenter extends BasePresenter<MainGalleryActivityView> {

	private final GetMainGalleryInteractor getMainGalleryInteractor;

	@Inject
	public MainGalleryActivityPresenter(GetMainGalleryInteractor getMainGalleryInteractor) {
		this.getMainGalleryInteractor = getMainGalleryInteractor;
	}

	public void loadData() {

		getMainGalleryInteractor.execute(new BaseDisposableObserver<List<String>>() {

			@Override
			public void onNext(List<String> strings) {
				//return data and update UI
			}

			@Override
			public void onError(Throwable t)  {
				super.onError(t);

				//update UI
			}
		});
	}
}
