package fr.iut.iem.comics.presentation.fragment;

import  android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.iut.iem.comics.ComicsApp;
import fr.iut.iem.comics.R;
import fr.iut.iem.comics.presentation.component.DisplayError;
import fr.iut.iem.comics.presentation.listener.ComicsNavigatorListener;
import fr.iut.iem.comics.presentation.presenter.ComicsDetailPresenter;
import fr.iut.iem.comics.presentation.view.ComicsDetailView;
import fr.iut.iem.comics.presentation.viewmodel.ComicsViewModel;

/**
 * Created by louis on 12/12/2017.
 */

public class ComicsDetailFragment extends Fragment implements ComicsDetailView {

    private static final String COMICS_ID_KEY = "fr.iut.iem.comics.presentation.fragment.ComicsDetailFragment.COMICS_ID_KEY";
    private ComicsDetailPresenter comicsDetailPresenter;
    private DisplayError displayError;
    private View view;

    @BindView(R.id.fragment_detail_title) TextView title;
    @BindView(R.id.fragment_detail_description) TextView description;
    @BindView(R.id.fragment_detail_date) TextView date;
    @BindView(R.id.fragment_detail_other_data) TextView otherData;
    @BindView(R.id.fragment_detail_credits) TextView credits;
    @BindView(R.id.fragment_detail_image) ImageView image;

    public static ComicsDetailFragment newInstance(int id) {
        ComicsDetailFragment fragment = new ComicsDetailFragment();
        Bundle args = new Bundle();

        args.putInt(COMICS_ID_KEY, id);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_comics_detail, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
        initCoponents();
    }

    @Override
    public void displayComics(ComicsViewModel comicsViewModel) {
        title.setText(comicsViewModel.getTitle());
        description.setText(comicsViewModel.getDescription());
        date.setText(comicsViewModel.getDate(getActivity()));
        otherData.setText(formatOtherData(comicsViewModel));
        credits.setText(comicsViewModel.getCreators(getActivity()));

        Picasso.with(getActivity()).load(comicsViewModel.getImage()).into(image);
    }

    @Override
    public void displayError() {
        displayError.displayError(view, getString(R.string.connection_message_error), getActivity());
    }

    private void initPresenter() {
        this.comicsDetailPresenter = new ComicsDetailPresenter ((ComicsNavigatorListener) getActivity(),
                ComicsApp.getInstance().getComicsRepository(),
                this);

        if(getArguments() != null && getArguments().containsKey(COMICS_ID_KEY)) {
            comicsDetailPresenter.getComicsById(getArguments().getInt(COMICS_ID_KEY));
        }
    }

    private void initCoponents() {
        displayError = ComicsApp.getInstance().getDisplayError();
    }

    private String formatOtherData(ComicsViewModel comicsViewModel) {
        String otherData = comicsViewModel.getPrice(getActivity())
                + ", "
                + comicsViewModel.getPageCount(getActivity())
                + " - "
                + comicsViewModel.getDiamondCode();

        return otherData;
    }

    @OnClick(R.id.comics_detail_back_button)
    public void onToolbarBackButtonClick() {
        comicsDetailPresenter.backAction();
    }

    @OnClick(R.id.comics_detail_share_button)
    public void onToolbarShareButtonClick() {
        comicsDetailPresenter.shareAction();
    }
}
