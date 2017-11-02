package marvelcomics.eoinahern.ie.marvelcomics.UI.Results;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import marvelcomics.eoinahern.ie.marvelcomics.R;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseActivity;

public class ResultsActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public int getLayout() {
		return R.layout.activity_results;
	}

	@Override
	public void inject() {
		//not required at present
	}

	public static Intent getStartIntent(Context context) {
		return new Intent(context, ResultsActivity.class);
	}
}
