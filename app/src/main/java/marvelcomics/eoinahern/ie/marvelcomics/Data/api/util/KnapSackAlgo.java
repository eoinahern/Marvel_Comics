package marvelcomics.eoinahern.ie.marvelcomics.Data.api.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;

public class KnapSackAlgo {

	private List<DomainComic> comicList;
	private int pages[];
	private int weight[];
	private int totalWeight;


	public KnapSackAlgo() {
		comicList = new ArrayList<>();
		totalWeight = 0;
		pages = new int[comicList.size()];
		weight = new int[comicList.size()];
	}

	public void setComicList(List<DomainComic> comicList) {

		if (!comicList.isEmpty()) {
			comicList.clear();
		}

		Collections.sort(comicList);
		comicList.addAll(comicList);
	}

	public void setWeight(int weight) {
		this.totalWeight = weight;
	}

	private void createArrays() {

		for (int i = 0; i < comicList.size(); i++) {

			DomainComic comic = comicList.get(i);
			pages[i] = comic.pages();
			weight[i] = (int) comic.floatprice() * 100;
		}
	}

	public void knapSackInit() {

		createArrays();
		knapSack(pages, weight, totalWeight, 0);
	}


	public int knapSack(int pages[], int wt[], int totalWeight, int index) {

		if (index == wt.length) return 0;
		if (totalWeight - wt[index] < 0) {
			return knapSack(pages, wt, totalWeight, index + 1);
		}


		return Math.max(knapSack(pages, wt, totalWeight - wt[index], index + 1) + pages[index],
				knapSack(pages, wt, totalWeight, index + 1));

	}


}
