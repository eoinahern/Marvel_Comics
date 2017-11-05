package marvelcomics.eoinahern.ie.marvelcomics.UI.Results;

import java.util.Map;

import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseView;


public interface ResultsActivityView extends BaseView {

	void showLoading();

	void HideLoading();

	void updateView(Map<Float, Integer> resultsMap);
}

