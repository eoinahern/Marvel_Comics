package marvelcomics.eoinahern.ie.marvelcomics.Domain.base;

import android.util.Log;

import io.reactivex.functions.Consumer;


public class BaseErrorSubscriber implements Consumer<Throwable> {

	@Override
	public void accept(Throwable throwable) throws Exception {
		Log.d("message", throwable.getMessage());
		throwable.printStackTrace();
	}
}
