package marvelcomics.eoinahern.ie.marvelcomics.UI.Results;

import java.util.List;
import java.util.Map;

import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.Entry;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseView;


public interface ResultsActivityView extends BaseView {

	void showLoading();

	void HideLoading();

	void showError();

	void hideError();

	void updateView(List<Entry> resultsMap);
}

