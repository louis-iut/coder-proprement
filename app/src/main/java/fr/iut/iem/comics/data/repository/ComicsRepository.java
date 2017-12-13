package fr.iut.iem.comics.data.repository;

import java.util.List;

import fr.iut.iem.comics.data.manager.ComicsApiManager;
import fr.iut.iem.comics.data.manager.ComicsCacheManager;
import fr.iut.iem.comics.data.model.remote.Comics;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by louis on 11/12/2017.
 */

public class ComicsRepository {

    private ComicsApiManager comicsApiManager;
    private ComicsCacheManager comicsCacheManager;

    public ComicsRepository(ComicsApiManager comicsApiManager, ComicsCacheManager comicsCacheManager) {
        this.comicsApiManager = comicsApiManager;
        this.comicsCacheManager = comicsCacheManager;
    }

    public Observable<Comics> getComicsById(final int id) {
        return getComicsList().map(new Func1<List<Comics>, Comics>() {
            @Override
            public Comics call(List<Comics> comicsList) {
                return findComicsWithId(comicsList, id);
            }
        });
    }

    public Observable<List<Comics>> getComicsList() {
        return getCache().onErrorResumeNext(new Func1<Throwable, Observable<? extends List<Comics>>>() {
            @Override
            public Observable<? extends List<Comics>> call(Throwable throwable) {
                return getComicsListFromApi();
            }
        });
    }

    public Observable<List<Comics>> getComicsListFromApi() {
        return getApi().doOnNext(new Action1<List<Comics>>() {
            @Override
            public void call(List<Comics> comicsList) {
                comicsCacheManager.setComicsList(comicsList);
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

    private  Observable<List<Comics>> getCache() {
        return  Observable.defer(new Func0<Observable<List<Comics>>>() {
            @Override
            public Observable<List<Comics>> call() {
                return Observable.just(comicsCacheManager.getComicsList());
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
