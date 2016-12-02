package com.luigh.raveen.luigh;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;

import static android.content.ContentValues.TAG;

/**
 * Created by raveen on 11/29/16.
 *
 */

public class OCRFunctions {

    private TessBaseAPI tessBaseAPI;
    private AssetManager assetManager;

    public OCRFunctions (){
        tessBaseAPI = new TessBaseAPI();
        String datapath = Environment.getExternalStorageDirectory().getPath() + "/tesseract/";
        System.out.println(datapath);
        String language = "eng";
        File dir = new File(datapath);
        if (!dir.exists()) {
            dir.mkdirs();

            File tess = new File(datapath + "tessdata");
            if (!tess.exists()){
                tess.mkdir();
            }

        }

        //Init the Tess with the trained data file, with english language
        tessBaseAPI.init(datapath, language);

    }

    public String detectText(Bitmap bitmap) {

        //we want to only detect numbers
        tessBaseAPI.setVariable(TessBaseAPI.VAR_CHAR_WHITELIST, "1234567890");
        tessBaseAPI.setVariable(TessBaseAPI.VAR_CHAR_BLACKLIST, "!@#$%^&*()_+=-qwertyuiop[]}{POIU" +
                "YTREWQasdASDfghFGHjklJKLl;L:'\"\\|~`xcvXCVbnmBNM,./<>?");

        tessBaseAPI.setImage(bitmap);
        String inspection = tessBaseAPI.getUTF8Text();
        Log.d(TAG, "Got data: " + inspection);
        tessBaseAPI.end();
        System.gc();
        return inspection;

    }
}
