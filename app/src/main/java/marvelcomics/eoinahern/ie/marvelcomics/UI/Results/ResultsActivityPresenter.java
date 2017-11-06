package marvelcomics.eoinahern.ie.marvelcomics.UI.Results;


import java.util.List;

import javax.inject.Inject;

import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.BaseDisposableObserver;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery.GetBudgetInfoInteractor;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.Entry;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BasePresenter;

@PerScreen
public class ResultsActivityPresenter extends BasePresenter<ResultsActivityView> {

	private final GetBudgetInfoInteractor getBudgetInfoInteractor;

	@Inject
	public ResultsActivityPresenter(GetBudgetInfoInteractor getBudgetInfoInteractor) {
		this.getBudgetInfoInteractor = getBudgetInfoInteractor;
	}

	@Override
	public void attachView(ResultsActivityView view) {
		super.attachView(view);
		getView().showLoading();
	}

	public void calculateResults(List<DomainComic> comicList) {

		getBudgetInfoInteractor.setComicList(comicList);
		getBudgetInfoInteractor.execute(new BaseDisposableObserver<List<Entry>>() {

			@Override
			public void onNext(List<Entry> entList) {

				getView().HideLoading();
				getView().updateView(entList);
			}

			@Override
			public void onError(Throwable t) {
				super.onError(t);
				getView().HideLoading();
				getView().showError();
			}
		});

	}

	@Override
	public void detachView() {
		super.detachView();
		getBudgetInfoInteractor.dispose();
	}


}
