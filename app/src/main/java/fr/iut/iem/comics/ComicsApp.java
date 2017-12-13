package fr.iut.iem.comics;

import android.app.Application;

import fr.iut.iem.comics.data.manager.ComicsApiManagerImpl;
import fr.iut.iem.comics.data.manager.ComicsCacheManagerImpl;
import fr.iut.iem.comics.data.repository.ComicsRepository;
import fr.iut.iem.comics.presentation.component.DisplayError;
import fr.iut.iem.comics.presentation.component.SnackBarError;
import fr.iut.iem.comics.presentation.component.ToastError;

/**
 * Created by louis on 11/12/2017.
 */

public class ComicsApp extends Application {

    private String jsonFile;

    private static ComicsApp application;
    private ComicsRepository comicsRepository;
    private DisplayError displayError;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

        jsonFile = getString(R.string.json_ok);
        //jsonFile = getString(R.string.json_ko);
        displayError = new SnackBarError();
        //displayError = new ToastError();

        comicsRepository = new ComicsRepository(new ComicsApiManagerImpl(this, jsonFile), new ComicsCacheManagerImpl());
    }

    public static ComicsApp getInstance() {
        return application;
    }

    public ComicsRepository getComicsRepository() {
        return comicsRepository;
    }

    public DisplayError getDisplayError() {
        return displayError;
    }

}
