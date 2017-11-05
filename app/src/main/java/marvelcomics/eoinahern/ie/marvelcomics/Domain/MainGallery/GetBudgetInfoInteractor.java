package marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelService;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.util.KnapSackAlgo;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.base.BaseInteractor;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;


@PerScreen
public class GetBudgetInfoInteractor extends BaseInteractor<Map<Float, Integer>> {

	private final KnapSackAlgo knapSackAlgo;
	private final MarvelService marvelService;

	@Inject
	public GetBudgetInfoInteractor(KnapSackAlgo knapSackAlgo, MarvelService marvelService) {
		this.knapSackAlgo = knapSackAlgo;
		this.marvelService = marvelService;
	}

	public void setComicList() {

	}


	@Override
	protected Observable<Map<Float, Integer>> buildObservable() {


		//1. 0/1 knasack dynamic programming problem
		//dont know shit about it.

		//weight = cost!!
		// total weight = budget !!!
		// value = number pages

		return null;
	}
}
