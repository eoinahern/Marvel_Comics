package marvelcomics.eoinahern.ie.marvelcomics.UI.Results;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;

public class ResultsActivity extends BaseActivity implements ResultsActivityView {


	private static final String COMIC = "comicList";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public int getLayout() {
		return R.layout.activity_results;
	}

	@Override
	public void inject() {
		//not required at present
	}

	public static Intent getStartIntent(Context context, List<DomainComic> comicList) {
		return new Intent(context, ResultsActivity.class)
				.putParcelableArrayListExtra("name", (ArrayList) comicList);
	}

	@Override
	public void showLoading() {

	}

	@Override
	public void HideLoading() {

	}

	@Override
	public void updateView(Map<Float, Integer> resultsMap) {

	}
}
