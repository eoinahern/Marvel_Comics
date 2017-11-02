package marvelcomics.eoinahern.ie.marvelcomics.Domain.models.mapper;

import android.text.Html;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;


@Singleton
public class ComicMapper {

	@Inject
	public ComicMapper() {
	}

	private String price;
	private float floatprice;
	private String fullTitle;
	private String abbreviatedTitle;
	private String description;
	private int pages;
	private String authors;
	private String smallImageUrl;
	private String mediumImageUrl;

	public DomainComic mapComicToDomainComic(Comic comic) {

		price = String.format("$%.2f", comic.prices().get(0).price());
		floatprice = comic.prices().get(0).price();
		fullTitle = comic.title();
		abbreviatedTitle = comic.title().split("\\(")[0];

		if (comic.description() != null)
			description = Html.fromHtml(comic.description()).toString();

		pages = comic.pageCount();
		authors = comic.creators().toString();
		smallImageUrl = comic.thumbnail().path() + "/portrait_small." + comic.thumbnail().extension();
		mediumImageUrl = comic.thumbnail().path() + "/portrait_medium." + comic.thumbnail().extension();

		return DomainComic.getInstance(price, floatprice,  fullTitle, abbreviatedTitle, description, pages,
				authors, smallImageUrl, mediumImageUrl);

	}

	public List<DomainComic> mapList(List<Comic> comicList) {

		List<DomainComic> domainList = new ArrayList<>();

		for (Comic comicitem : comicList) {
			domainList.add(mapComicToDomainComic(comicitem));
		}

		return domainList;
	}
}
