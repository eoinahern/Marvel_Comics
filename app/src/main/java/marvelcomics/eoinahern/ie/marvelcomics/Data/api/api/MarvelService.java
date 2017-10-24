package marvelcomics.eoinahern.ie.marvelcomics.Data.api.api;


import java.util.List;

import io.reactivex.Observable;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;
import retrofit2.http.GET;

public interface MarvelService {

	@GET("v1/public/comics")
	Observable<List<Comic>> getComics();
}
