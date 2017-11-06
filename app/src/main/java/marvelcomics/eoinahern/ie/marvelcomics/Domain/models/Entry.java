package marvelcomics.eoinahern.ie.marvelcomics.Domain.models;

public class Entry {

	private float cost;
	private int pages;

	public float getCost() {
		return cost;
	}

	public int getPages() {
		return pages;
	}

	public Entry(float cost, int pages) {
		this.cost = cost;
		this.pages = pages;
	}
}
