package marvelcomics.eoinahern.ie.marvelcomics.Data.api.typeadapter;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

@GsonTypeAdapterFactory
public abstract class GsonAdapterFactory implements TypeAdapterFactory {

	public static TypeAdapterFactory create() {
		return new AutoValueGson_GsonAdapterFactory();
	}

}
