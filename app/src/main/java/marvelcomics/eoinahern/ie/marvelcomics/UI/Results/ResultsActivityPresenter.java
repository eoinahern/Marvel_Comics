package marvelcomics.eoinahern.ie.marvelcomics.UI.Results;


import javax.inject.Inject;
import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery.GetBudgetInfoInteractor;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BasePresenter;

@PerScreen
public class ResultsActivityPresenter extends BasePresenter<ResultsActivityView> {

	private final GetBudgetInfoInteractor getBudgetInfoInteractor;

	@Inject
	public ResultsActivityPresenter(GetBudgetInfoInteractor getBudgetInfoInteractor) {
		this.getBudgetInfoInteractor = getBudgetInfoInteractor;
	}

	public void calculateResults() {

	}


}
