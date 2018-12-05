package com.koekoetech.androidcommonlibrary.custom_control;

import android.content.Context;

import com.koekoetech.androidcommonlibrary.helper.AndroidCommonSetup;

/* Created by hello on 3/12/18.*/

public class MyanTextProcessor {

    public static String processText(Context context, String original_text) {

        switch (AndroidCommonSetup.getInstance().getZgOrMM3()) {
            case "zg":
                original_text = Rabbit.uni2zg(original_text);
                break;
            default:
                break;

        }

        return original_text;
    }

}
