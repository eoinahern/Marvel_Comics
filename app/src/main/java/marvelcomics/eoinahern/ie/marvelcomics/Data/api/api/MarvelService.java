package marvelcomics.eoinahern.ie.marvelcomics.Data.api.api;


import java.util.List;

import io.reactivex.functions.Consumer;
import retrofit2.http.GET;

public interface MarvelService {

	@GET("/stuff")
	 Consumer<List<String>> stuff() ;
}
