package fr.iut.iem.comics.presentation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.iut.iem.comics.R;
import fr.iut.iem.comics.presentation.listener.ComicsNavigatorListener;
import fr.iut.iem.comics.presentation.navigator.ComicsNavigator;

public class ComicsActivity extends AppCompatActivity implements ComicsNavigatorListener{

    ComicsNavigator comicsNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);

        comicsNavigator = new ComicsNavigator(getFragmentManager(), this);
        displayComicsList();
    }

    @Override
    public void displayComicsDetail(int id) {
        comicsNavigator.launchDetailFragment(id);
    }

    @Override
    public void displayComicsList() {
        comicsNavigator.launchListFragment();
    }

    @Override
    public void shareAction(String url) {
        comicsNavigator.shareAction(url);
    }

    @Override
    public void onBackPressed() {
        comicsNavigator.backAction();
    }
}
