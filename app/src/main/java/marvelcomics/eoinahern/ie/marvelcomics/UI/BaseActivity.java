package marvelcomics.eoinahern.ie.marvelcomics.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {

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

	public abstract int getLayout();

	public abstract void inject();
}
