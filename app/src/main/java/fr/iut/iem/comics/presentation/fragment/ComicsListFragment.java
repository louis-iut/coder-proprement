package fr.iut.iem.comics.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.iut.iem.comics.ComicsApp;
import fr.iut.iem.comics.R;
import fr.iut.iem.comics.presentation.adapter.ComicsListAdapter;
import fr.iut.iem.comics.presentation.component.DisplayError;
import fr.iut.iem.comics.presentation.listener.ComicsListListener;
import fr.iut.iem.comics.presentation.listener.ComicsNavigatorListener;
import fr.iut.iem.comics.presentation.presenter.ComicsListPresenter;
import fr.iut.iem.comics.presentation.view.ComicsListView;
import fr.iut.iem.comics.presentation.viewmodel.ComicsViewModel;

/**
 * Created by iem on 12/12/2017.
 */

public class ComicsListFragment extends Fragment implements ComicsListView, ComicsListListener {

    private DisplayError displayError;
    private View view;
    private ComicsListPresenter comicsListPresenter;
    private ComicsListAdapter comicsListAdapter;

    RecyclerView comicsListRecyclerView;
    SwipeRefreshLayout comicsListSwipeRefresh;

    public static ComicsListFragment newInstance(){
        ComicsListFragment fragment = new ComicsListFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_comics_list, container, false);

        initPresenter();
        initCoponents();
        initRecyclerView();
        initSwipeRefresh();

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

    private void initRecyclerView() {
        comicsListAdapter = new ComicsListAdapter(getActivity(), this);
        comicsListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        comicsListRecyclerView.setAdapter(comicsListAdapter);
    }

    private void initCoponents() {
        displayError = ComicsApp.getInstance().getDisplayError();
    }

    private void initSwipeRefresh() {
        comicsListSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                comicsListPresenter.getComicsList();
                comicsListSwipeRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    public void onClickOnComicsInList(int id) {
        comicsListPresenter.onClickOnComicsInList(id);
    }
}
