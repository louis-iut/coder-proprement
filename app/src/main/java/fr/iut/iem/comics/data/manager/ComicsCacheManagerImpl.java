package fr.iut.iem.comics.data.manager;

import java.util.ArrayList;
import java.util.List;

import fr.iut.iem.comics.data.model.remote.Comics;

/**
 * Created by QuentinGenevois on 13/12/2017.
 */

public class ComicsCacheManagerImpl implements ComicsCacheManager {

    private List<Comics> comicsList;

    public ComicsCacheManagerImpl() {
        this.comicsList = new ArrayList<>();
    }

    @Override
    public List<Comics> getComicsList() throws RuntimeException{
        if (!comicsList.isEmpty()) {
            return comicsList;
        }

        throw new RuntimeException();
    }

    @Override
    public void setComicsList(List<Comics> comicsList) {
        this.comicsList = comicsList;
    }

}
