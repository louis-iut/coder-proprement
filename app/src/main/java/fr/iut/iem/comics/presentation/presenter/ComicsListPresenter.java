package fr.iut.iem.comics.presentation.presenter;

import java.util.ArrayList;
import java.util.List;

import fr.iut.iem.comics.data.model.remote.Comics;
import fr.iut.iem.comics.data.repository.ComicsRepository;
import fr.iut.iem.comics.presentation.listener.ComicsNavigatorListener;
import fr.iut.iem.comics.presentation.view.ComicsListView;
import fr.iut.iem.comics.presentation.viewmodel.ComicsViewModel;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by QuentinGenevois on 12/12/2017.
 */

public class ComicsListPresenter {

    private ComicsListView comicsListView;
    private ComicsNavigatorListener comicsNavigatorListener;
    private ComicsRepository comicsRepository;

    public ComicsListPresenter(ComicsNavigatorListener comicsNavigatorListener,
                               ComicsRepository comicsRepository,
                               ComicsListView comicsListView) {

        this.comicsNavigatorListener = comicsNavigatorListener;
        this.comicsRepository = comicsRepository;
        this.comicsListView = comicsListView;
    }

    public void getComicsList() {
        observe(comicsRepository.getComicsList());
    }

    private void observe(Observable<List<Comics>> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Comics>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        comicsListView.displayError();
                    }

                    @Override
                    public void onNext(List<Comics> comicsList) {
                        comicsListView.updateList(comicsListToComicsViewModelList(comicsList));
                    }
                });
    }

    private List<ComicsViewModel> comicsListToComicsViewModelList(List<Comics> comicsList) {
        List<ComicsViewModel> comicsViewModels = new ArrayList<>();

        for (Comics comics : comicsList) {
            comicsViewModels.add(comicsToComicsViewModel(comics));
        }

        return comicsViewModels;
    }

    private ComicsViewModel comicsToComicsViewModel(Comics comics) {
        return new ComicsViewModel(comics);
    }
}
