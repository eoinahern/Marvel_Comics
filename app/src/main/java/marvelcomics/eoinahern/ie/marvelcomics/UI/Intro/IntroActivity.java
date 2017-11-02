package marvelcomics.eoinahern.ie.marvelcomics.UI.Intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;
import marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery.MainGalleryActivity;

/**
 * effectively a splash screen!
 */
public class IntroActivity extends BaseActivity {

	private Handler handler;
	private Animation animation;
	@BindView(R.id.logo_imageview) ImageView logoImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ButterKnife.bind(this);

		runAnimation();

		handler = new Handler();
		handler.postDelayed(()
				->
		{
			startActivity(new Intent(IntroActivity.this, MainGalleryActivity.class));
			finish();

		}, 1400);
	}

	private void runAnimation() {
		animation = AnimationUtils.loadAnimation(this, R.anim.intro_animation);
		logoImageView.startAnimation(animation);

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
