package fr.iut.iem.comics.presentation.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import fr.iut.iem.comics.data.model.remote.Comics;
import fr.iut.iem.comics.presentation.listener.ComicsListListener;
import fr.iut.iem.comics.presentation.viewmodel.ComicsViewModel;

/**
 * Created by iem on 12/12/2017.
 */

public class ComicsListViewHolder extends RecyclerView.ViewHolder{
    public ComicsListViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(Context context, ComicsViewModel comics, ComicsListListener comicsListListener){

    }

}
