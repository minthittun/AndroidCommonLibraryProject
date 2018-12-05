package com.koekoetech.androidcommonlibraryproject.app;

import android.app.Application;

import com.koekoetech.androidcommonlibrary.helper.AndroidCommonSetup;
import com.koekoetech.androidcommonlibrary.helper.TextDictionaryHelper;

public class AndroidCommonLibraryApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidCommonSetup.getInstance().init(getApplicationContext());

    }



}
