package marvelcomics.eoinahern.ie.marvelcomics.UI.ComicInfo;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;
import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;

public class ComicInfoActivity extends BaseActivity {

	private static final String COMIC = "comic";
	@BindView(R.id.comic_image) SimpleDraweeView comicImage;
	@BindView(R.id.toolbar) Toolbar toolbar;
	@BindView(R.id.description) TextView description;

	private Comic comic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		comic = getComic();
		setImage();
		setActionBar();
		setText();
	}

	public Comic getComic() {
		return (Comic) getIntent().getParcelableExtra(COMIC);
	}

	public void setActionBar() {
		setSupportActionBar(toolbar);
		toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
		toolbar.setTitle(comic.title());
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_back_dark);
	}

	public void setImage() {
		comicImage.setImageURI(Uri.parse(comic.thumbnail().path() + "/portrait_small." + comic.thumbnail().extension()));
	}

	public void setText() {

		if (comic.description() != null)
			description.setText(Html.fromHtml(comic.description()).toString());

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				this.finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}


	@Override
	public int getLayout() {
		return R.layout.activity_comic_info;
	}

	@Override
	public void inject() {

	}

	public static Intent getStartIntent(Context context, Comic comic) {
		return new Intent(context, ComicInfoActivity.class).putExtra(COMIC, comic);

	}
}
