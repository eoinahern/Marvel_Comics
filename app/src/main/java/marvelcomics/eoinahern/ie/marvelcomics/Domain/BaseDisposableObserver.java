package marvelcomics.eoinahern.ie.marvelcomics.Domain;


import android.support.annotation.CallSuper;
import android.util.Log;

import io.reactivex.observers.DisposableObserver;

public abstract  class BaseDisposableObserver<T> extends DisposableObserver<T> {


	@Override
	public void onComplete(){
	}

	@Override
	@CallSuper
	public void onError(Throwable t) {

		Log.d("message", t.getMessage());
		Log.d("cause", t.getLocalizedMessage());

	}
}
