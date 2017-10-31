package marvelcomics.eoinahern.ie.marvelcomics.Data.api.models;


import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

@AutoValue
public abstract class ComicCreators implements Parcelable {

	public abstract int available();

	public abstract List<ComicCreatorData> items();

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (ComicCreatorData item : items()) {

			if (items().indexOf(item) != items().size() - 1) {
				sb.append(item.name() + ", ");
			} else {
				sb.append(item.name());
			}
		}

		return sb.toString();
	}

	public static TypeAdapter<ComicCreators> typeAdapter(Gson gson) {
		return new AutoValue_ComicCreators.GsonTypeAdapter(gson);
	}
}
