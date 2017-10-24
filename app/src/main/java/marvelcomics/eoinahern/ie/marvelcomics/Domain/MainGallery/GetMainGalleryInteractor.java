package marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import marvelcomics.eoinahern.ie.marvelcomics.DI.annotation.PerScreen;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelService;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.base.BaseInteractor;


@PerScreen
public class GetMainGalleryInteractor extends BaseInteractor<List<String>> {

	private final MarvelService marvelService;

	@Inject
	public GetMainGalleryInteractor(MarvelService marvelService) {
		this.marvelService = marvelService;
	}

	@Override
	protected Observable<List<String>> buildObservable() {
		return null;
	}
}
