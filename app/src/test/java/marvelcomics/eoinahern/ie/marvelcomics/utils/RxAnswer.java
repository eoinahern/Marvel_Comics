package marvelcomics.eoinahern.ie.marvelcomics.utils;


import org.mockito.stubbing.Answer;

import io.reactivex.observers.DisposableObserver;

public class RxAnswer {

	public static <T> Answer onNextCompleted(T ... values) {

		return invocation -> {

			DisposableObserver<T>  dispObs = (DisposableObserver) invocation.getArguments()[0];

			for(T value : values) {

				if(value != null) {
					dispObs.onNext(value);
				}  else {
					dispObs.onNext(null);
				}
			}

			dispObs.onComplete();
			return null;
		};
	}
}
