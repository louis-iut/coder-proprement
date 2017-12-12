package fr.iut.iem.comics.presentation.listener;

/**
 * Created by louis on 12/12/2017.
 */

public interface ComicsNavigatorListener {

    void displayComicsDetail(int id);
    void displayComicsList();
    void onBackPressed();
    void shareAction(String url);

}
