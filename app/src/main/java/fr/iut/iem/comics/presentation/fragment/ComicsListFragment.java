package fr.iut.iem.comics.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.iut.iem.comics.ComicsApp;
import fr.iut.iem.comics.R;
import fr.iut.iem.comics.data.model.remote.Comics;
import fr.iut.iem.comics.presentation.component.DisplayError;
import fr.iut.iem.comics.presentation.listener.ComicsNavigatorListener;
import fr.iut.iem.comics.presentation.navigator.ComicsNavigator;
import fr.iut.iem.comics.presentation.presenter.ComicsListPresenter;
import fr.iut.iem.comics.presentation.view.ComicsListView;
import fr.iut.iem.comics.presentation.viewmodel.ComicsViewModel;

/**
 * Created by iem on 12/12/2017.
 */

public class ComicsListFragment extends Fragment implements ComicsListView {

    private DisplayError displayError;
    private View view;
    private ComicsListPresenter comicsListPresenter;

    public static ComicsListFragment newInstance(){
        ComicsListFragment fragment = new ComicsListFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_comics_list, container, false);
        displayError = ComicsApp.getInstance().getDisplayError();
        initPresenter();

        return view;
    }

    @Override
    public void updateList(List<ComicsViewModel> comicsViewModels) {

    }

    @Override
    public void displayError() {
        displayError.displayError(view, getString(R.string.connection_message_error));
    }

    private void initPresenter() {
        comicsListPresenter = new ComicsListPresenter((ComicsNavigatorListener) getActivity(), ComicsApp.getInstance().getComicsRepository(), this);
        comicsListPresenter.getComicsList();
    }
}
