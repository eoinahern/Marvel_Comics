package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;

public class MainGalleryActivity extends BaseActivity implements MainGalleryActivityView {

	@BindView(R.id.toolbar) Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public int getLayout() {
		return R.layout.activity_gallery_main;
	}

	@Override
	public void inject() {

	}
}
