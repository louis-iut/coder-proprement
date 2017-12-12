package fr.iut.iem.comics.presentation.viewmodel;

import fr.iut.iem.comics.data.model.remote.Comics;

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
        return comics.getDate();
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
        return  "";
    }
}
