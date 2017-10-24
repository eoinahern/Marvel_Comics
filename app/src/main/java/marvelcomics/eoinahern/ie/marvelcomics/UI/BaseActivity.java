package marvelcomics.eoinahern.ie.marvelcomics.UI;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import marvelcomics.eoinahern.ie.marvelcomics.R;

public abstract class BaseActivity extends AppCompatActivity {

	//protected @BindView(R.id.toolbar) Toolbar toolbar;
	protected ActionBar actionBar;

	@Override
	protected void onCreate(Bundle siState) {
		super.onCreate(siState);

		int layout = getLayout();

		if (layout != 0) {
			setContentView(layout);
			ButterKnife.bind(this);
		}

		inject();
	}

	protected void setUpToolbar() {
		//setSupportActionBar(toolbar);
		//actionBar = getSupportActionBar();
	}

	public abstract int getLayout();

	public abstract void inject();
}
