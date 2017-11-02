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

	/**
	 * return and observable with map detailing a budget and the
	 * number of pages i can get for this budget.
	 * @return Observable
	 */

	@Override
	protected Observable<Map<Float, Integer>> buildObservable() {


		//1. sort arraylist
		//2. helper method calculate anout of pages i can get for 1/3 of the total cost.
		//3. helper method calculate amount of pages i can get for 2/3 of the total cost.
		//4. add values to map and return.
		return null;
	}
}
