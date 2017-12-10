package fr.iut.iem.comics.data.manager;

import java.util.List;

import fr.iut.iem.comics.data.model.remote.ComicsRemoteEntity;

/**
 * Created by louis on 10/12/2017.
 */

public interface ComicsApiManager {
    List<ComicsRemoteEntity> getComicsList();
}
