package marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.base.BaseInteractor;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;


@PerScreen
public class GetBudgetInfoInteractor extends BaseInteractor<Map<Float, Integer>> {

	private List<DomainComic> comicList;

	@Inject
	public GetBudgetInfoInteractor() {
		comicList = new ArrayList<>();
	}

	public void setComicList(List<DomainComic> comiclist) {

		if(!comicList.isEmpty()) {
			comicList.clear();
		}

		comicList.addAll(comiclist);
	}

	@Override
	protected Observable<Map<Float, Integer>> buildObservable() {
		return null;
	}
}
