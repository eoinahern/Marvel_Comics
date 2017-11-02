package marvelcomics.eoinahern.ie.marvelcomics.Data.api.models;


import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public  abstract class ComicCreatorData implements Parcelable {

	public abstract String name();

	public static TypeAdapter<ComicCreatorData> typeAdapter(Gson gson) {
		return new AutoValue_ComicCreatorData.GsonTypeAdapter(gson);
	}
}
