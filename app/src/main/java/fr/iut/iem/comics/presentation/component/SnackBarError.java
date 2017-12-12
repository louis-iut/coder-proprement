package fr.iut.iem.comics.presentation.component;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import fr.iut.iem.comics.R;

/**
 * Created by Guillaume Colletaz on 12/12/2017.
 */

public class SnackBarError implements DisplayError{

    @Override
    public void displayError(View view, int message) {
        Snackbar snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_LONG);
        View snackbarView = snackbar.getView();

        TextView textView= (TextView) snackbarView.findViewById(R.id.snackbar_text);

        snackbarView.setBackgroundColor(Color.RED);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        snackbar.show();
    }

}
