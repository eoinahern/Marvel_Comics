package marvelcomics.eoinahern.ie.marvelcomics.Data.api.api;

import io.reactivex.Observable;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.ComicWrapper;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MarvelService {

	@GET("v1/public/comics")
	@Headers({"Content-Type: application/json",
		"Accept: */*"})
	Observable<ComicWrapper> getComics();
}
