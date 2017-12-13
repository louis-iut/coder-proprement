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

    public Observable<List<Comics>> getComicsList() {
        return getCache().onErrorResumeNext(new Func1<Throwable, Observable<? extends List<Comics>>>() {
            @Override
            public Observable<? extends List<Comics>> call(Throwable throwable) {
                return getApi().doOnNext(new Action1<List<Comics>>() {
                    @Override
                    public void call(List<Comics> comicsList) {
                        comicsCacheManager.setComicsList(comicsList);
                    }
                });
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
}
