package marvelcomics.eoinahern.ie.marvelcomics.Data.api.models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class ComicPrice {

	public abstract String type();

	public abstract float price();

	public static TypeAdapter<ComicPrice> typeAdapter(Gson gson) {
		return new AutoValue_ComicPrice.GsonTypeAdapter(gson);
	}
}
