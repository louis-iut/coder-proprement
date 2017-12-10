package fr.iut.iem.comics.data.utils;

import android.content.Context;
import android.util.Log;

import java.io.InputStream;

import fr.iut.iem.comics.R;

/**
 * Created by louis on 10/12/2017.
 */

public class FileReader {

    public static String readFile(Context context, String fileName) {
        String content = null;

        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];

            inputStream.read(buffer);
            inputStream.close();

            content = new String(buffer, context.getString(R.string.charset_name));
        } catch (Exception e) {
            Log.e(context.getString(R.string.file_reading_error), e.getMessage());
        }

        return content;
    }
}
