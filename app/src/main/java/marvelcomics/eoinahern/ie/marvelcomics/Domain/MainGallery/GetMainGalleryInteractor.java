package marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelService;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.ComicWrapper;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.base.BaseInteractor;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.mapper.ComicMapper;


@PerScreen
public class GetMainGalleryInteractor extends BaseInteractor<List<DomainComic>> {

	private final MarvelService marvelService;
	private final ComicMapper mapper;

	@Inject
	public GetMainGalleryInteractor(MarvelService marvelService, ComicMapper mapper) {
		this.marvelService = marvelService;
		this.mapper = mapper;
	}

	@Override
	public Observable<List<DomainComic>> buildObservable() {

		return marvelService.getComics()
				.map(comicWrapper -> mapper.mapList(comicWrapper.data().results()));
	}
}
