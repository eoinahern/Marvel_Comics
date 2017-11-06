package marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.util.KnapSackAlgo;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.base.BaseInteractor;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.Entry;

@PerScreen
public class GetBudgetInfoInteractor extends BaseInteractor<List<Entry>> {

	private final KnapSackAlgo knapSackAlgo;
	private List<DomainComic> comicList;

	@Inject
	public GetBudgetInfoInteractor(KnapSackAlgo knapSackAlgo) {
		this.knapSackAlgo = knapSackAlgo;
		comicList = new ArrayList<>();
	}

	public void setComicList(List<DomainComic> comicList) {
		this.comicList.addAll(comicList);
	}

	@Override
	protected Observable<List<Entry>> buildObservable() {

		return Observable.fromCallable(() -> {

			List<Entry> entryList = new ArrayList<>();

			//setup
			knapSackAlgo.setComicList(comicList);
			knapSackAlgo.createArrays();

			int[] pages = knapSackAlgo.getPages();
			int[] weight = knapSackAlgo.getWeights();

			//hard code some cost values

			entryList.add(0,new Entry(2.00f,
					knapSackAlgo.knapSack(pages, weight, 200, 0)));

			entryList.add(1,new Entry(5.00f,
					knapSackAlgo.knapSack(pages, weight, 500, 0)));

			entryList.add(2,new Entry(7.00f,
					knapSackAlgo.knapSack(pages, weight, 700, 0)));

			return entryList;
		});
	}
}
