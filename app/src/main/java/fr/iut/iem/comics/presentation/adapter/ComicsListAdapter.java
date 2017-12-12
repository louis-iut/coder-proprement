package fr.iut.iem.comics.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import fr.iut.iem.comics.data.model.remote.Comics;
import fr.iut.iem.comics.presentation.viewholder.ComicsListViewHolder;

/**
 * Created by iem on 12/12/2017.
 */

public class ComicsListAdapter extends RecyclerView.Adapter<ComicsListViewHolder> {

    private final Context context;
    private List<Comics> comicsList;

    public ComicsListAdapter(Context context){
        this.context = context;
    }

    public void setComicsList(List<Comics> comicsList) {
        this.comicsList = comicsList;
    }

    @Override
    public ComicsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ComicsListViewHolder holder, int position) {
        holder.bind(context,comicsList.get(position));
    }

    @Override
    public int getItemCount() {
        return comicsList.size();
    }
}
