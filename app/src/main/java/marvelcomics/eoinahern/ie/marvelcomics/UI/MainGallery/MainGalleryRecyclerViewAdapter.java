package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;
import marvelcomics.eoinahern.ie.marvelcomics.R;

public class MainGalleryRecyclerViewAdapter extends RecyclerView.Adapter<MainGalleryRecyclerViewAdapter.ViewHolder> {

	private List<Comic> comicList;

	public MainGalleryRecyclerViewAdapter() {
		this.comicList = new ArrayList<>();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item, parent, false);
		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

		Comic comic = comicList.get(position);
		holder.comicImage.setImageURI(Uri.parse(comic.thumbnail().path() + "/portrait_medium."  + comic.thumbnail().extension()));
		holder.comicName.setText(comic.title());
	}

	public void updateView(List<Comic> comicListIn) {

		if(!comicList.isEmpty()) {
			comicList.clear();
		}

		comicList.addAll(comicListIn);
		notifyDataSetChanged();
	}

	@Override
	public int getItemCount() {
		return comicList.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		@BindView(R.id.comic_image) SimpleDraweeView comicImage;
		@BindView(R.id.comic_name) TextView comicName;

		public ViewHolder(View view) {
			super(view);
			ButterKnife.bind(this, view);

		}
	}
}
