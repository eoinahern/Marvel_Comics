package marvelcomics.eoinahern.ie.marvelcomics.Data.api.models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class ComicWrapper {

	public abstract int code();

	public abstract String status();

	public abstract ComicContainer data();

	public static TypeAdapter<ComicWrapper> typeAdapter(Gson gson) {
		return new AutoValue_ComicWrapper.GsonTypeAdapter(gson);
	}
}
