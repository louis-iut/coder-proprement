package fr.iut.iem.comics.data.manager;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import fr.iut.iem.comics.R;
import fr.iut.iem.comics.data.model.remote.Comics;
import fr.iut.iem.comics.data.utils.FileReader;

/**
 * Created by louis on 10/12/2017.
 */

public class ComicsApiManagerImpl implements ComicsApiManager {

    private Context context;
    private String fileName;
    private List<Comics> comicsList;

    public ComicsApiManagerImpl(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    @Override
    public List<Comics> getComicsList() {
        String json = getJson();
        parseJson(json);

        return comicsList;
    }

    private void parseJson(String json) {
        Gson gson = new GsonBuilder()
                .setDateFormat(context.getString(R.string.json_date_format))
                .create();

        ResultEnvelop resultEnvelop = gson.fromJson(json, ResultEnvelop.class);
        comicsList = resultEnvelop.getComicsList();
    }

    private String getJson() {
        return FileReader.readFile(context, fileName);
    }

    public class ResultEnvelop {
        @SerializedName("results")
        @Expose
        private List<Comics> comicsList = null;

        public List<Comics> getComicsList() {
            return comicsList;
        }
    }
}
