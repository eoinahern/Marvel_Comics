package marvelcomics.eoinahern.ie.marvelcomics.Domain.models;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class DomainComic implements Parcelable, Comparable<DomainComic> {

	public abstract String price();

	public abstract float floatprice();

	public abstract String fullTitle();

	public abstract String abbreviatedTitle();

	@Nullable
	public abstract String description();

	public abstract int pages();

	public abstract String authors();

	public abstract String smallImageUrl();

	public abstract String mediumImageUrl();

	@Override
	public int compareTo(DomainComic other) {

		if (this.floatprice() < other.floatprice()) {
			return -1;
		} else if (this.floatprice() > other.floatprice()) {
			return 1;
		}

		return 0;
	}

	public static TypeAdapter<DomainComic> getTypeAdapter(Gson gson) {
		return new AutoValue_DomainComic.GsonTypeAdapter(gson);
	}

	public static DomainComic getInstance(String price, float floatPrice, String fullTitle, String abbreviatedTitle, String description, int pages,
										  String authors, String smallImageUrl, String mediumImageUrl) {

		return new AutoValue_DomainComic(price, floatPrice, fullTitle, abbreviatedTitle, description, pages,
				authors, smallImageUrl, mediumImageUrl);
	}
}
