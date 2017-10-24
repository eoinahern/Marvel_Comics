package marvelcomics.eoinahern.ie.marvelcomics.Domain.base;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseInteractor<T> {

	protected CompositeDisposable disposables =  new CompositeDisposable();

	protected abstract Observable<T> buildObservable();

	public void execute(DisposableObserver<T> obs) {

		 disposables.add(buildObservable()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeWith(obs));
	}

	public void dispose() {

		if (!disposables.isDisposed()) {
			disposables.dispose();
		}
	}
}
