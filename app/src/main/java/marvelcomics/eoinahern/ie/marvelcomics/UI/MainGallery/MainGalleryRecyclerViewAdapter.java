package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;

/**
 * Created by eoin_a on 23/10/2017.
 */

public class MainGalleryRecyclerViewAdapter extends RecyclerView.Adapter<MainGalleryRecyclerViewAdapter.ViewHolder> {

	private List<Comic> comicList;

	public MainGalleryRecyclerViewAdapter() {
		this.comicList = new ArrayList<>();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return null;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

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


		public ViewHolder(View itemView) {
			super(itemView);
		}
	}
}
