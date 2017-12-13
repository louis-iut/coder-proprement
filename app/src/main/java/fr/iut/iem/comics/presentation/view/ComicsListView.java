package fr.iut.iem.comics.presentation.view;

import java.util.List;

import fr.iut.iem.comics.data.model.remote.Comics;

/**
 * Created by louis on 12/12/2017.
 */

public interface ComicsListView {
    void updateList(List<Comics> comicsList);
}
