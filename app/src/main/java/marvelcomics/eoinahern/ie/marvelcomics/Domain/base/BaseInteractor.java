package marvelcomics.eoinahern.ie.marvelcomics.Domain.base;

import io.reactivex.Observable;
import io.reactivex.Scheduler;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;

@PerScreen
public abstract class BaseInteractor<T> {

	protected CompositeDisposable disposables = new CompositeDisposable();

	protected abstract Observable<T> buildObservable();

	public void execute(DisposableObserver<T> obs) {

		disposables.add(buildObservable()
				.subscribeOn(getIOScheduler())
				.observeOn(getMaintThreadScheduler())
				.subscribeWith(obs));
	}

	public Scheduler getMaintThreadScheduler(){
		return AndroidSchedulers.mainThread();
	}

	public Scheduler getIOScheduler() {
		return Schedulers.io();
	}

	public void dispose() {

		if (!disposables.isDisposed()) {
			disposables.dispose();
		}
	}
}
