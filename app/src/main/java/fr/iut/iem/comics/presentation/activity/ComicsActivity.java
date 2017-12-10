package fr.iut.iem.comics.presentation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.iut.iem.comics.R;
import fr.iut.iem.comics.data.manager.ComicsApiManager;
import fr.iut.iem.comics.data.manager.ComicsApiManagerImpl;

public class ComicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);
    }
}
