package fr.iut.iem.comics.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.iut.iem.comics.R;
import fr.iut.iem.comics.presentation.listener.ComicsListListener;
import fr.iut.iem.comics.presentation.viewholder.ComicsListViewHolder;
import fr.iut.iem.comics.presentation.viewmodel.ComicsViewModel;

/**
 * Created by iem on 12/12/2017.
 */

public class ComicsListAdapter extends RecyclerView.Adapter<ComicsListViewHolder> {

    private final Context context;
    private final ComicsListListener comicsListListener;
    private List<ComicsViewModel> comicsList;

    public ComicsListAdapter(Context context, ComicsListListener comicsListListener){
        this.comicsList = new ArrayList<>();
        this.context = context;
        this.comicsListListener = comicsListListener;
    }

    public void setComicsList(List<ComicsViewModel> comicsList) {
        this.comicsList = comicsList;
        notifyDataSetChanged();
    }

    @Override
    public ComicsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_holder_comics, parent, false);

        return new ComicsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComicsListViewHolder holder, int position) {
        holder.bind(context, comicsList.get(position), comicsListListener);
    }

    @Override
    public int getItemCount() {
        return comicsList.size();
    }
}
