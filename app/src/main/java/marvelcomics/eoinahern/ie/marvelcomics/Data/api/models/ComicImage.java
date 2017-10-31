package marvelcomics.eoinahern.ie.marvelcomics.Data.api.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class ComicImage implements Parcelable {

	public abstract String path();

	public abstract String extension();

	public static TypeAdapter<ComicImage> typeAdapter(Gson gson) {
		return new AutoValue_ComicImage.GsonTypeAdapter(gson);
	}
}
