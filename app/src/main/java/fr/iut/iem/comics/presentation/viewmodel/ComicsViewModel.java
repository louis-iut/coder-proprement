package fr.iut.iem.comics.presentation.viewmodel;

import android.content.Context;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.iut.iem.comics.R;
import fr.iut.iem.comics.data.model.remote.Comics;
import fr.iut.iem.comics.data.model.remote.Creator;

/**
 * Created by Guillaume Colletaz on 12/12/2017.
 */

public class ComicsViewModel {

    private static final String TAG = ComicsViewModel.class.getName();
    private Comics comics;

    public ComicsViewModel(Comics comics) {
        this.comics = comics;
    }

    public String getTitle() {
        return comics.getTitle();
    }

    public String getDescription() {
        return comics.getDescription();
    }

    public String getDiamondCode() {
        return comics.getDiamondCode();
    }

    public String getDate(Context context) {

        SimpleDateFormat preFormater = new SimpleDateFormat(context.getString(R.string.json_date_format));
        DateFormat dateFormat = null;
        SimpleDateFormat postFormater = new SimpleDateFormat(context.getString(R.string.detail_view_date_format));
        String newDateString = null;

        try
        {
            Date date = preFormater.parse(comics.getDate());
            newDateString = postFormater.format(date);
        }
        catch (ParseException e)
        {
            Log.e(TAG, context.getString(R.string.date_parse_error));
            return comics.getDate().toString();
        }

        return newDateString;
    }

    public String getPrice() {
        return comics.getPrice() + "€";
    }

    public String getPageCount() {
        return Integer.toString(comics.getPageCount());
    }

    public String getImage() {
        return comics.getImage();
    }

    public String getCreators(Context context) {

        StringBuilder creatorsListBuilder = new StringBuilder();
        creatorsListBuilder.append(context.getString(R.string.comicsviewmodel_creators_header));
        for (Creator creator: comics.getCreators()) {
            creatorsListBuilder.append(creator.getRole());
            creatorsListBuilder.append(" : ");
            creatorsListBuilder.append(creator.getName());
            creatorsListBuilder.append("\n");
        }

        String creatorsList = new String(creatorsListBuilder);

        return creatorsList;
    }
}
