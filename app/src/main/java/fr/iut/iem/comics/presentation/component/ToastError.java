package fr.iut.iem.comics.presentation.component;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import android.widget.ViewAnimator;

/**
 * Created by Guillaume Colletaz on 12/12/2017.
 */

public class ToastError implements DisplayError {

    @Override
    public void displayError(View view, String message, Context context) {
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

}
