package fr.iut.iem.comics.presentation.view;

import java.util.List;

import fr.iut.iem.comics.data.model.remote.Comics;
import fr.iut.iem.comics.presentation.viewmodel.ComicsViewModel;

/**
 * Created by louis on 12/12/2017.
 */

public interface ComicsListView {
    void updateList(List<ComicsViewModel> comicsViewModels);
    void displayError();
}
