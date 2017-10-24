package marvelcomics.eoinahern.ie.marvelcomics.UI.Intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;
import marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery.MainGalleryActivity;


/**
 * effectively a splash screen!
 */
public class IntroActivity extends BaseActivity {

	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(IntroActivity.this, MainGalleryActivity.class));
			}
		}, 1000);

	}

	@Override
	public int getLayout() {
		return R.layout.activity_intro;
	}

	@Override
	public void inject() {
		//not required here
	}
}
