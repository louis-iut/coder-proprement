package fr.iut.iem.comics.presentation.view;

import fr.iut.iem.comics.presentation.viewmodel.ComicsViewModel;

/**
 * Created by louis on 12/12/2017.
 */

public interface ComicsDetailView {
    void updateComics(ComicsViewModel comicsViewModel);
    void displayError();
}
