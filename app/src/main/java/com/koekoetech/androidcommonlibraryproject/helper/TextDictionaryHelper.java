package com.koekoetech.androidcommonlibraryproject.helper;

import android.content.Context;

import com.koekoetech.androidcommonlibrary.helper.AndroidCommonConstant;
import com.koekoetech.androidcommonlibrary.helper.AndroidCommonSetup;
import com.koekoetech.androidcommonlibrary.helper.TextModel;

import java.util.ArrayList;

public class TextDictionaryHelper {


    public static final String TEXT_VERSION = "TEXT_VERSION";
    public static final String ABOUT_US = "ABOUT_US";

    public static ArrayList<TextModel> list = new ArrayList<TextModel>() {{


        add(new TextModel(TEXT_VERSION, "Version", "ဗားရှင်း"));
        add(new TextModel(ABOUT_US, "About us", "App အကြောင်း"));

    }};

    public static String getText(Context context, String key)
    {
        String result = "";
        for(int i = 0; i<list.size(); i++)
        {
            if(list.get(i).getKey().equals(key))
            {
                TextModel model = list.get(i);

                switch(AndroidCommonSetup.getInstance().getSelectedLanguage()) {
                    case AndroidCommonConstant.ENGLISH_LANGUAGE :
                        result = model.getEnglish();
                        break;
                    default :
                        result = model.getMyanmar();
                        break;
                }

            }
        }

        return  result;
    }

}
