package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import marvelcomics.eoinahern.ie.marvelcomics.App;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;
import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;

public class MainGalleryActivity extends BaseActivity implements MainGalleryActivityView {

	@BindView(R.id.toolbar) Toolbar toolbar;
	@Inject MainGalleryActivityPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		presenter.attachView(this);
		presenter.loadData();
	}

	@Override
	public int getLayout() {
		return R.layout.activity_gallery_main;
	}

	@Override
	public void inject() {
		App.get(this).getComponent().plus(new MainGalleryActivityComponent.MainGalleryActivityModule(this)).inject(this);
	}

	@Override
	public void showLoading() {

	}

	@Override
	public void hideLoading() {

	}

	@Override
	public void updateRecycler(List<Comic> comics) {

		if(comics ==null || comics.isEmpty()) {
			Log.d("empty", "null or empty");
		}


		Log.d("not empty", "yaaaaay!!");
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
