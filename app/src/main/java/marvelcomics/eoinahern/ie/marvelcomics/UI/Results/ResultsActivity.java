package marvelcomics.eoinahern.ie.marvelcomics.UI.Results;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import marvelcomics.eoinahern.ie.marvelcomics.App;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.Entry;
import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class ResultsActivity extends BaseActivity implements ResultsActivityView {

	private static final String COMIC = "comicList";
	@Inject ResultsActivityPresenter presenter;
	@Inject ResultsActivityAdapter adapter;

	@BindView(R.id.progbar) MaterialProgressBar progbar;
	@BindView(R.id.err_msg) TextView errorMsg;
	@BindView(R.id.recycler) RecyclerView recycler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setUpRecycler();
		presenter.attachView(this);
		presenter.calculateResults(getIntent().getParcelableArrayListExtra(COMIC));
	}

	@Override
	public int getLayout() {
		return R.layout.activity_results;
	}

	@Override
	public void inject() {
		App.get(this).getComponent().plus(new ResultsActivityComponent.ResultsActivityComponentModule(this)).inject(this);
	}

	public static Intent getStartIntent(Context context) {
		return new Intent(context, ResultsActivity.class);
	}

	public void setUpRecycler() {
		recycler.setLayoutManager(new LinearLayoutManager(this));
		recycler.setAdapter(adapter);
	}

	@Override
	public void showLoading() {
		progbar.setVisibility(View.VISIBLE);
	}

	@Override
	public void HideLoading() {
		progbar.setVisibility(View.GONE);
	}

	@Override
	public void showError() {
		errorMsg.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideError() {
		errorMsg.setVisibility(View.GONE);
	}

	@Override
	public void updateView(List<Entry> resList) {

		if (!resList.isEmpty()) {
			hideError();
			adapter.setResultsMap(resList);
		} else {
			showError();
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		presenter.detachView();
	}
}
