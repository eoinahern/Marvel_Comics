package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import java.util.List;

import javax.inject.Inject;

import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.ComicWrapper;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.BaseDisposableObserver;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery.GetMainGalleryInteractor;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BasePresenter;

@PerScreen
public class MainGalleryActivityPresenter extends BasePresenter<MainGalleryActivityView> {

	private final GetMainGalleryInteractor getMainGalleryInteractor;

	@Inject
	public MainGalleryActivityPresenter(GetMainGalleryInteractor getMainGalleryInteractor) {
		this.getMainGalleryInteractor = getMainGalleryInteractor;
	}

	public void loadData() {

		getView().showLoading();

		getMainGalleryInteractor.execute(new BaseDisposableObserver<List<DomainComic>>() {

			@Override
			public void onNext(List<DomainComic> comicList) {
				//return data and update UI

				getView().hideLoading();
				getView().updateRecycler(comicList);
			}

			@Override
			public void onError(Throwable t) {
				super.onError(t);
				getView().hideLoading();
				getView().showError();
			}
		});
	}

	public void navigateToComic(DomainComic comic) {
		getView().goToComicInfo(comic);
	}

	@Override
	public void detachView() {
		super.detachView();
		getMainGalleryInteractor.dispose();
	}
}
