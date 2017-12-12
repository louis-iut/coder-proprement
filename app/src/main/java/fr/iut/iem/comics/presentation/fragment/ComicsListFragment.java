package fr.iut.iem.comics.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.iut.iem.comics.R;

/**
 * Created by iem on 12/12/2017.
 */

public class ComicsListFragment extends Fragment{

    public static ComicsListFragment  newinstance(){
        ComicsListFragment fragment = new ComicsListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comics_list, container, false);
        return view;
    }

}
