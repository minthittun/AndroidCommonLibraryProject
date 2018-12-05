package com.koekoetech.androidcommonlibrary.custom_control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.koekoetech.androidcommonlibrary.R;


public class MyanToast {

    /*public static Toast makeText(Activity context, String text, int duration) {

        LayoutInflater inflater = context.getLayoutInflater();
        // Inflate the Layout
        View layout = inflater.inflate(R.layout.toast_layout, null);

        MyanTextView textView = layout.findViewById(R.id.txtToastMessage);
        // Set the Text to show in TextView
        textView.setMyanmarText(text);

        Toast toast = new Toast(context);
        toast.setDuration(duration);
        toast.setView(layout);

        return toast;
    }*/

    public static void makeText(Context context, String text) {

        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the Layout
        View layout = inflater.inflate(R.layout.toast_layout, null);

        MyanTextView textView = layout.findViewById(R.id.txtToastMessage);
        // Set the Text to show in TextView
        textView.setMyanmarToastText(text);

        Toast.makeText(context, textView.getText(), Toast.LENGTH_SHORT).show();
    }
}
