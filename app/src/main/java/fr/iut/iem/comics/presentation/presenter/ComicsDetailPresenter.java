package fr.iut.iem.comics.presentation.presenter;

import fr.iut.iem.comics.data.model.remote.Comics;
import fr.iut.iem.comics.data.repository.ComicsRepository;
import fr.iut.iem.comics.presentation.listener.ComicsNavigatorListener;
import fr.iut.iem.comics.presentation.view.ComicsDetailView;
import fr.iut.iem.comics.presentation.viewmodel.ComicsViewModel;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by louis on 12/12/2017.
 */

public class ComicsDetailPresenter {

    private ComicsDetailView comicsDetailView;
    private ComicsNavigatorListener comicsNavigatorListener;
    private ComicsRepository comicsRepository;
    private String stringToShare;

    public ComicsDetailPresenter(ComicsNavigatorListener comicsNavigatorListener,
                                 ComicsRepository comicsRepository,
                                 ComicsDetailView comicsDetailView) {
        this.comicsDetailView = comicsDetailView;
        this.comicsNavigatorListener = comicsNavigatorListener;
        this.comicsRepository = comicsRepository;
    }

    public void getComicsById(int id) {
        observe(comicsRepository.getComicsById(id));
    }

    private void observe(Observable<Comics> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Comics>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        comicsDetailView.displayError();
                    }

                    @Override
                    public void onNext(Comics comicsEntity) {
                        stringToShare = comicsEntity.getImage();
                        comicsDetailView.displayComics(new ComicsViewModel(comicsEntity));
                    }
                });
    }

    public void backAction() {
        comicsNavigatorListener.onBackPressed();
    }

    public void shareAction() {
        comicsNavigatorListener.shareAction(stringToShare);
    }
}
