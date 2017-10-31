package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import marvelcomics.eoinahern.ie.marvelcomics.App;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;
import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class MainGalleryActivity extends BaseActivity implements MainGalleryActivityView {

	@BindView(R.id.toolbar) Toolbar toolbar;
	@BindView(R.id.recycler) RecyclerView recyclerView;
	@BindView(R.id.progbar) MaterialProgressBar progbar;

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
	public void updateRecycler(List<Comic> comics) {

		if (comics != null && !comics.isEmpty()) {
			adapter.updateView(comics);
		}
	}

	@Override
	public void showError() {
		Log.d("empty", "null or empty");
	}


	@Override
	public void onDestroy() {
		super.onDestroy();
		presenter.detachView();
	}
}
