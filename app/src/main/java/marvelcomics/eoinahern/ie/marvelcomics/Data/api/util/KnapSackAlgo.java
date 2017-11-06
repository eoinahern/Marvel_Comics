package marvelcomics.eoinahern.ie.marvelcomics.Data.api.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;

@PerScreen
public class KnapSackAlgo {

	private List<DomainComic> comicList;
	private int pages[];
	private int weight[];

	@Inject
	public KnapSackAlgo() {
		comicList = new ArrayList<>();
	}

	public void setComicList(List<DomainComic> comiclist) {

		if (!comicList.isEmpty()) {
			comicList.clear();
		}

		Collections.sort(comiclist);
		this.comicList.addAll(removeItemsWithNoPages(comiclist));
		setArraySize();
	}

	private List<DomainComic> removeItemsWithNoPages(List<DomainComic> comiclist) {

		List<DomainComic> comicList = new ArrayList<>();

		for (DomainComic comic : comiclist) {
			if (comic.pages() > 0)
				comicList.add(comic);
		}

		return comicList;
	}

	private void setArraySize() {
		pages = new int[comicList.size()];
		weight = new int[comicList.size()];
	}

	public void createArrays() {

		for (int i = 0; i < comicList.size(); i++) {

			DomainComic comic = comicList.get(i);
			pages[i] = comic.pages();
			weight[i] = (int) (comic.floatprice() * 100f);
		}

	}

	public int[] getPages() {
		return pages;
	}

	public int[] getWeights() {
		return weight;
	}

	public int knapSack(int pages[], int wt[], int totalWeight, int index) {

		if (index == wt.length) {
			return 0;
		}
		if (totalWeight - wt[index] < 0) {
			return knapSack(pages, wt, totalWeight, index + 1);
		}

		if (wt[index] == 0) {
			return knapSack(pages, wt, totalWeight, index + 1) + pages[index];
		}

		return Math.max(knapSack(pages, wt, totalWeight - wt[index], index + 1) + pages[index],
				knapSack(pages, wt, totalWeight, index + 1));

	}
}
