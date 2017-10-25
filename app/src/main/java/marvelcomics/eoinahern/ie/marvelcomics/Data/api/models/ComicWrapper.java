package marvelcomics.eoinahern.ie.marvelcomics.Data.api.models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class ComicWrapper {

	@SerializedName("code")
	public abstract int code();

	@SerializedName("status")
	public abstract String status();

	@SerializedName("data")
	public abstract ComicContainer data();

	public static TypeAdapter<ComicWrapper> typeAdapter(Gson gson) {
		return new AutoValue_ComicWrapper.GsonTypeAdapter(gson);
	}
}
