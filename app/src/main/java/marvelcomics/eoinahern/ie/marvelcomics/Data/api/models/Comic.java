package marvelcomics.eoinahern.ie.marvelcomics.Data.api.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

@AutoValue
public abstract class Comic implements Parcelable {

	public abstract int id();

	public abstract int digitalId();

	public abstract String title();

	public abstract String format();

	public abstract int pageCount();

	public abstract List<ComicPrice> prices();

	public abstract List<ComicImage> images();

	public abstract ComicImage thumbnail();

	public static TypeAdapter<Comic> getTypeAdapter(Gson gson) {
		return new AutoValue_Comic.GsonTypeAdapter(gson);
	}
}
