package fr.iut.iem.comics.presentation.navigator;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;

import fr.iut.iem.comics.R;
import fr.iut.iem.comics.presentation.fragment.ComicsListFragment;
import fr.iut.iem.comics.presentation.view.ComicsDetailView;
import fr.iut.iem.comics.presentation.view.ComicsListView;

/**
 * Created by louis on 12/12/2017.
 */

public class ComicsNavigator {

    private final FragmentManager fragmentManager;
    private final Context context;

    private final static int COMICS_LIST_FRAGMENT = 0;
    private final static int COMICS_DETAIL_FRAGMENT = 1;
    private int currentFragment;


    public ComicsNavigator(FragmentManager fragmentManager, Context context) {
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    public void launchListFragment() {
        ComicsListView comicsListView = ComicsListFragment.newInstance();

        fragmentManager
                .beginTransaction()
                .addToBackStack(context.getString(R.string.comics_list_view))
                .add(R.id.root_layout, (Fragment) comicsListView)
                .commit();

        currentFragment = COMICS_LIST_FRAGMENT;
    }

    public void launchDetailFragment(int id) {
        ComicsDetailView comicsDetailView;
    }

    public void backAction() {
        if (currentFragment == COMICS_DETAIL_FRAGMENT) {
            fragmentManager.popBackStack();
            currentFragment = COMICS_LIST_FRAGMENT;
        }
    }

    public void shareAction(String url) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(context.getString(R.string.intent_type_text));
        intent.putExtra(Intent.EXTRA_TEXT, url);
        context.startActivity(Intent.createChooser(intent, context.getString(R.string.intent_sharing_message)));
    }

}
