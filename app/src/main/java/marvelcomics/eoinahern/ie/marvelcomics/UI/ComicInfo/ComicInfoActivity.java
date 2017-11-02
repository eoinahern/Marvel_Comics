package marvelcomics.eoinahern.ie.marvelcomics.UI.ComicInfo;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;

public class ComicInfoActivity extends BaseActivity {

	private static final String COMIC = "comic";
	@BindView(R.id.comic_image) SimpleDraweeView comicImage;
	@BindView(R.id.toolbar) Toolbar toolbar;
	@BindView(R.id.description) TextView description;
	@BindView(R.id.authors_txt) TextView authors;
	@BindView(R.id.title) TextView title;
	@BindView(R.id.price) TextView price;
	@BindView(R.id.pages) TextView pages;

	private DomainComic comic;
	private ActionBar acBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		comic = getComic();
		setImage();
		setActionBar();
		setText();
	}

	public DomainComic getComic() {
		return (DomainComic) getIntent().getParcelableExtra(COMIC);
	}

	public void setActionBar() {
		setSupportActionBar(toolbar);
		acBar = getSupportActionBar();
		toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
		acBar.setHomeButtonEnabled(true);
		acBar.setDisplayHomeAsUpEnabled(true);
		acBar.setHomeAsUpIndicator(R.drawable.ic_action_back_dark);
		acBar.setTitle(R.string.details);
	}

	public void setImage() {
		comicImage.setImageURI(Uri.parse(comic.smallImageUrl()));
	}

	public void setText() {

		if (comic.description() != null)
			description.setText(comic.description());
		title.setText(comic.abbreviatedTitle());
		price.setText(comic.price());
		pages.setText(String.valueOf(comic.pages()));

		if (!comic.authors().isEmpty())
			authors.setText(comic.authors());
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
		//not required at present
	}

	public static Intent getStartIntent(Context context, DomainComic comic) {
		return new Intent(context, ComicInfoActivity.class).putExtra(COMIC, comic);

	}
}
