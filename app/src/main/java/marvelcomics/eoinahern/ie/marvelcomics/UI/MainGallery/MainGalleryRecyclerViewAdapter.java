package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import android.net.Uri;
import android.support.v7.view.menu.MenuView;
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
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.R;

public class MainGalleryRecyclerViewAdapter extends RecyclerView.Adapter<MainGalleryRecyclerViewAdapter.ViewHolder> {

	private List<DomainComic> comicList;
	private final MainGalleryActivityPresenter presenter;

	public MainGalleryRecyclerViewAdapter(MainGalleryActivityPresenter presenter) {
		this.presenter = presenter;
		this.comicList = new ArrayList<>();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item, parent, false);
		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

		DomainComic comic = comicList.get(position);
		holder.comicImage.setImageURI(Uri.parse(comic.mediumImageUrl()));
		holder.comicName.setText(comic.fullTitle());
	}

	public void updateView(List<DomainComic> comicListIn) {

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

	public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		@BindView(R.id.comic_image) SimpleDraweeView comicImage;
		@BindView(R.id.comic_name) TextView comicName;

		public ViewHolder(View view) {
			super(view);
			ButterKnife.bind(this, view);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			Log.d("position", String.valueOf(getAdapterPosition()));
			presenter.navigateToComic(comicList.get(getAdapterPosition()));
		}
	}
}
