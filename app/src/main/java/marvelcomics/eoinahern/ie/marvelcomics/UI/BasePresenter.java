package marvelcomics.eoinahern.ie.marvelcomics.UI;


public class BasePresenter<V extends BaseView> implements Presenter<V> {

	protected V view;

	@Override
	public void attachView(V mvpView) {
		this.view = mvpView;
	}

	@Override
	public void detachView() {

		this.view = null;
	}

	public final V getView() {
		return view;
	}
}
