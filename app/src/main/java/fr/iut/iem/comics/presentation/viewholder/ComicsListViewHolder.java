package fr.iut.iem.comics.presentation.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.iut.iem.comics.R;
import fr.iut.iem.comics.presentation.listener.ComicsListListener;
import fr.iut.iem.comics.presentation.viewmodel.ComicsViewModel;

/**
 * Created by iem on 12/12/2017.
 */

public class ComicsListViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.fragment_text_view_title) TextView title;
    @BindView(R.id.fragment_text_view_date) TextView date;
    @BindView(R.id.fragment_text_view_pagecount) TextView pageCount;
    @BindView(R.id.fragment_image_view_image_comics) ImageView comicsImage;

    public ComicsListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Context context, final ComicsViewModel comics, final ComicsListListener comicsListListener){
        title.setText(comics.getTitle());
        date.setText(comics.getDate(context));
        pageCount.setText(comics.getPageCount(context));
        Picasso.with(context).load(comics.getImage()).into(comicsImage);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comicsListListener.onClickOnComicsInList(comics.getComics().getId());
            }
        });
    }

}
