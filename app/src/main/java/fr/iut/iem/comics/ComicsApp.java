package fr.iut.iem.comics;

import android.app.Application;

import fr.iut.iem.comics.data.manager.ComicsApiManagerImpl;
import fr.iut.iem.comics.data.repository.ComicsRepository;

/**
 * Created by louis on 11/12/2017.
 */

public class ComicsApp extends Application {

    private String jsonFile;

    private static ComicsApp application;
    private ComicsRepository comicsRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
        //jsonFile = getString(R.string.json_ok);
        jsonFile = getString(R.string.json_ko);
        comicsRepository = new ComicsRepository(new ComicsApiManagerImpl(this, jsonFile));
    }

    public static ComicsApp getInstance() {
        return application;
    }

    public ComicsRepository getComicsRepository() {
        return comicsRepository;
    }
}
