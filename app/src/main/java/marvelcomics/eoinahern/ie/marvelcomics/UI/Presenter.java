package marvelcomics.eoinahern.ie.marvelcomics.UI;

/**
 * Created by eoin_a on 21/10/2017.
 */

public interface Presenter<V extends BaseView> {

	void attachView(V mvpView);

	void detachView();
}
