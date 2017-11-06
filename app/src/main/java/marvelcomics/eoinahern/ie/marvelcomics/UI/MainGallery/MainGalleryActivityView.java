package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import java.util.List;

import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.UI.BaseView;


public interface MainGalleryActivityView extends BaseView {

	void showLoading();

	void hideLoading();

	void updateRecycler(List<DomainComic> comics);

	void showError();

	void hideError();

	void goToComicInfo(DomainComic comic);
}
