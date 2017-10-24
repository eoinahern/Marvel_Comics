package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import butterknife.BindView;
import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;

public class MainGalleryActivity extends BaseActivity implements MainGalleryActivityView {

	@BindView(R.id.toolbar) Toolbar toolbar;
	@Inject MainGalleryActivityPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		presenter.attachView(this);
	}

	@Override
	public int getLayout() {
		return R.layout.activity_gallery_main;
	}

	@Override
	public void inject() {

	}

	@Override
	public void showLoading() {

	}

	@Override
	public void hideLoading() {

	}

	@Override
	public void updateRecycler() {

	}


	@Override
	public void onDestroy() {
		super.onDestroy();
		presenter.detachView();
	}
}
