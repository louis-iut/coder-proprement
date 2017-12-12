package fr.iut.iem.comics.data.repository;

import java.util.List;

import fr.iut.iem.comics.data.manager.ComicsApiManager;
import fr.iut.iem.comics.data.model.remote.Comics;
import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by louis on 11/12/2017.
 */

public class ComicsRepository {

    private ComicsApiManager comicsApiManager;
    //private ComicsCacheManager comicsCacheManager;

    public ComicsRepository(ComicsApiManager comicsApiManager) {
        this.comicsApiManager = comicsApiManager;
    }

    public Observable<List<Comics>> getComicsList() {
        return getApi();
    }

    public Observable<Comics> getComicsById(final int id) {
        return getComicsList().map(new Func1<List<Comics>, Comics>() {
            @Override
            public Comics call(List<Comics> comicsList) {
                return findComicsWithId(comicsList, id);
            }
        });
    }

    private Observable<List<Comics>> getApi() {
        return Observable.defer(new Func0<Observable<List<Comics>>>() {
            @Override
            public Observable<List<Comics>> call() {
                return Observable.just(comicsApiManager.getComicsList());
            }
        });
    }

    private Comics findComicsWithId(List<Comics> comicsList, int id) {
        for (Comics comics : comicsList) {
            if (comics.getId() == id) {
                return comics;
            }
        }

        return null;
    }
}
