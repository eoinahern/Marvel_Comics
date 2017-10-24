package marvelcomics.eoinahern.ie.marvelcomics.Data.api.models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

@AutoValue
public abstract class ComicContainer {

	public abstract int offset();

	public abstract int limit();

	public abstract int total();

	public abstract int count();

	public abstract List<Comic> results();

	public static TypeAdapter<ComicContainer> typeAdapter(Gson gson) {
		return new AutoValue_ComicContainer.GsonTypeAdapter(gson);
	}
}
