package fr.iut.iem.comics.presentation.component;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import fr.iut.iem.comics.R;

/**
 * Created by Guillaume Colletaz on 12/12/2017.
 */

public class SnackBarError implements DisplayError{

    @Override
    public void displayError(View view, String message, Context context) {
        Snackbar snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_LONG);
        View snackbarView = snackbar.getView();

        TextView textView= (TextView) snackbarView.findViewById(R.id.snackbar_text);

        snackbarView.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        snackbar.show();
    }

}
