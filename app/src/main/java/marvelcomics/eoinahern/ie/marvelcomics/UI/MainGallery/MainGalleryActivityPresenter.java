package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import javax.inject.Inject;

import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.ComicWrapper;
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

		getView().showLoading();

		getMainGalleryInteractor.execute(new BaseDisposableObserver<ComicWrapper>() {

			@Override
			public void onNext(ComicWrapper wrapper) {
				//return data and update UI

				getView().hideLoading();
				getView().updateRecycler(wrapper.data().results());
			}

			@Override
			public void onError(Throwable t) {
				super.onError(t);
				getView().hideLoading();
				getView().showError();
				//update UI
			}
		});
	}

	@Override
	public void detachView() {
		super.detachView();
		getMainGalleryInteractor.dispose();
	}
}
