package fr.iut.iem.comics.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.iut.iem.comics.R;
import fr.iut.iem.comics.data.model.remote.Comics;
import fr.iut.iem.comics.presentation.view.ComicsListView;

/**
 * Created by iem on 12/12/2017.
 */

public class ComicsListFragment extends Fragment implements ComicsListView{

    public static ComicsListFragment newInstance(){
        ComicsListFragment fragment = new ComicsListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comics_list, container, false);
        return view;
    }

    @Override
    public void updateList(List<Comics> comicsList) {

    }
}
