package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import marvelcomics.eoinahern.ie.marvelcomics.App;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;
import marvelcomics.eoinahern.ie.marvelcomics.UI.ComicInfo.ComicInfoActivity;
import marvelcomics.eoinahern.ie.marvelcomics.UI.Results.ResultsActivity;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class MainGalleryActivity extends BaseActivity implements MainGalleryActivityView {

	@BindView(R.id.toolbar) Toolbar toolbar;
	@BindView(R.id.recycler) RecyclerView recyclerView;
	@BindView(R.id.progbar) MaterialProgressBar progbar;
	@BindView(R.id.fab) FloatingActionButton fab;
	@BindView(R.id.error_txt) TextView errorTxt;

	private ActionBar acBar;

	@Inject MainGalleryActivityPresenter presenter;
	@Inject MainGalleryRecyclerViewAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		presenter.attachView(this);
		presenter.loadData();

		setUpActionBar();
		setUpRecyclerView();
	}

	@Override
	public int getLayout() {
		return R.layout.activity_gallery_main;
	}

	@Override
	public void inject() {
		App.get(this).getComponent().plus(new MainGalleryActivityComponent.MainGalleryActivityModule(this)).inject(this);
	}

	public void setUpActionBar() {

		setSupportActionBar(toolbar);
		toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
		acBar = getSupportActionBar();
		acBar.setTitle(R.string.gallery_name);
	}

	@Override
	public void showLoading() {
		progbar.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideLoading() {
		progbar.setVisibility(View.GONE);
		recyclerView.setVisibility(View.VISIBLE);
	}

	public void setUpRecyclerView() {
		recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
		recyclerView.setAdapter(adapter);
	}

	@Override
	public void updateRecycler(List<DomainComic> comics) {

		if (comics != null && !comics.isEmpty()) {
			hideError();
			adapter.updateView(comics);
		}
	}

	@Override
	public void showError() {
		errorTxt.setVisibility(View.VISIBLE);
		Log.d("empty", "null or empty");
	}

	@Override
	public void hideError() {
		errorTxt.setVisibility(View.GONE);
	}

	@Override
	public void goToComicInfo(DomainComic comic) {
		startActivity(ComicInfoActivity.getStartIntent(this, comic));
	}


	@Override
	public void onDestroy() {
		super.onDestroy();
		presenter.detachView();
	}

	@OnClick(R.id.fab)
	public void openResultsActivity() {
		startActivity(ResultsActivity.getStartIntent(this)
				.putParcelableArrayListExtra("comicList", (ArrayList) adapter.getComicList()));
	}
}
