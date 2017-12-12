package fr.iut.iem.comics.presentation.viewmodel;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.iut.iem.comics.data.model.remote.Comics;
import fr.iut.iem.comics.data.model.remote.Creator;

/**
 * Created by Guillaume Colletaz on 12/12/2017.
 */

public class ComicsViewModel {

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

    public String getDate() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        DateFormat dateFormat = null;
        SimpleDateFormat postFormater = new SimpleDateFormat("EEE d MMM yyyy");
        String newDateString = null;

        try
        {
            Date date = simpleDateFormat.parse(comics.getDate());
            newDateString = postFormater.format(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
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

    public String getCreators() {

        StringBuilder creatorsListBuilder = new StringBuilder();
        creatorsListBuilder.append("-Creators : \n");
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
