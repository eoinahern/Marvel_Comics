package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import java.util.List;

import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseView;


public interface MainGalleryActivityView extends BaseView {

	void showLoading();

	void hideLoading();

	void updateRecycler(List<Comic> comics);

	void showError();

	void goToComicInfo(Comic comic);
}
