package fr.iut.iem.comics.data.manager;

import java.util.List;

import fr.iut.iem.comics.data.model.remote.Comics;

/**
 * Created by QuentinGenevois on 13/12/2017.
 */

public interface ComicsCacheManager {
    List<Comics> getComicsList();
    void setComicsList(List<Comics> comicsList);
}