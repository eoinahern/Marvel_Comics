package marvelcomics.eoinahern.ie.marvelcomics.UI.ComicInfo;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;
import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;

public class ComicInfoActivity extends BaseActivity {

	private static final String COMIC = "comic";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public int getLayout() {
		return R.layout.activity_comic_info;
	}

	@Override
	public void inject() {

	}

	public static Intent getStartIntent(Context context, Comic comic){
		return new Intent(context, ComicInfoActivity.class).putExtra(COMIC, comic);

	}
}
