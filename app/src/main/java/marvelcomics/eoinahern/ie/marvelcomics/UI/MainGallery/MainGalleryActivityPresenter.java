package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.BaseDisposableObserver;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery.GetBudgetInfoInteractor;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery.GetMainGalleryInteractor;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BasePresenter;

@PerScreen
public class MainGalleryActivityPresenter extends BasePresenter<MainGalleryActivityView> {

	private final GetMainGalleryInteractor getMainGalleryInteractor;
	private final GetBudgetInfoInteractor getBudgetInfoInteractor;


	@Inject
	public MainGalleryActivityPresenter(GetMainGalleryInteractor getMainGalleryInteractor,
										GetBudgetInfoInteractor getBudgetInfoInteractor) {
		this.getMainGalleryInteractor = getMainGalleryInteractor;
		this.getBudgetInfoInteractor = getBudgetInfoInteractor;
	}

	public void loadData() {

		getView().showLoading();

		getMainGalleryInteractor.execute(new BaseDisposableObserver<List<DomainComic>>() {

			@Override
			public void onNext(List<DomainComic> comicList) {
				//return data and update UI

				getView().hideLoading();
				getView().updateRecycler(comicList);
				getBudgetInfoInteractor.setComicList(comicList);
			}

			@Override
			public void onError(Throwable t) {
				super.onError(t);
				getView().hideLoading();
				getView().showError();
			}
		});
	}


	public void getBudgetInfo() {

		getBudgetInfoInteractor.execute(new BaseDisposableObserver<Map<Float, Integer>>() {


			@Override
			public void onNext(Map<Float, Integer> floatIntegerMap) {
				//return results map and show it in a dialog!
			}


			@Override
			public void onError(Throwable t) {
				super.onError(t);
				//show error dialog
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
