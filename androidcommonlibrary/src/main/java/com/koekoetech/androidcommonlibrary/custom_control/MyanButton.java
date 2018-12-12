package com.koekoetech.androidcommonlibrary.custom_control;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/* Created by hello on 3/13/18.*/

public class MyanButton extends AppCompatButton {

    private Context context;

    public MyanButton(Context context) {
        super(context);

        this.context = context;

        applyCustomFont(context);
        setText(MyanTextProcessor.processText(getContext(), getText().toString()));
        
    }

    public MyanButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
        setText(MyanTextProcessor.processText(getContext(), getText().toString()));
        setStateListAnimator(null);
    }

    public MyanButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        applyCustomFont(context);
        setText(MyanTextProcessor.processText(getContext(), getText().toString()));
        setStateListAnimator(null);
    }

    public void setMyanmarText(String text) {
        applyCustomFont(context);
        setText(MyanTextProcessor.processText(getContext(), text));
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("Avenir-Regular.ttf", context);
        setTypeface(customFont);
    }

}
