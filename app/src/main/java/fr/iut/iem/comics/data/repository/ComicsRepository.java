package fr.iut.iem.comics.data.repository;

import java.util.List;

import fr.iut.iem.comics.data.manager.ComicsApiManager;
import fr.iut.iem.comics.data.model.remote.Comics;
import rx.Observable;
import rx.functions.Func0;

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

    private Observable<List<Comics>> getApi() {
        return Observable.defer(new Func0<Observable<List<Comics>>>() {
            @Override
            public Observable<List<Comics>> call() {
                return Observable.just(comicsApiManager.getComicsList());
            }
        });
    }
}
