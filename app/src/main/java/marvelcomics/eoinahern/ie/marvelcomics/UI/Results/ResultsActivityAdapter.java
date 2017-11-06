package marvelcomics.eoinahern.ie.marvelcomics.UI.Results;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.Entry;
import marvelcomics.eoinahern.ie.marvelcomics.R;

public class ResultsActivityAdapter extends RecyclerView.Adapter<ResultsActivityAdapter.ViewHolder> {

	private List<Entry> entryList;

	public ResultsActivityAdapter() {
		this.entryList = new ArrayList<>();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.budget_result_row, parent, false);
		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

		Entry ent = entryList.get(position);

		holder.budget.setText(String.format("$%.2f", ent.getCost()));
		holder.pages.setText(String.valueOf(ent.getPages()));
		holder.index.setText(String.valueOf(position + 1));

	}

	@Override
	public int getItemCount() {
		return entryList.size();
	}

	public void setResultsMap(List<Entry> entList) {

		if (!entryList.isEmpty()) {
			entryList.clear();
		}

		entryList.addAll(entList);
		notifyDataSetChanged();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		public @BindView(R.id.budget) TextView budget;
		public @BindView(R.id.pages) TextView pages;
		public @BindView(R.id.index) TextView index;

		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);

		}
	}
}
