package com.koekoetech.androidcommonlibrary.custom_control;


import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.AttributeSet;

/* Created by hello on 3/13/18.*/

public class MyanEditText extends AppCompatEditText {

    public MyanEditText(Context context) {
        super(context);
        if (getHint() != null) {
            setHint(MyanTextProcessor.processText(getContext(), getHint().toString()));
        }
    }

    public MyanEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (getHint() != null) {
            setHint(MyanTextProcessor.processText(getContext(), getHint().toString()));
        }
    }

    public MyanEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (getHint() != null) {
            setHint(MyanTextProcessor.processText(getContext(), getHint().toString()));
        }
    }

    public String getMyanmarText() {
        if (MyanmarZawgyiConverter.isZawgyiEncoded(getText().toString())) {
            return Rabbit.zg2uni(getText().toString());
        } else {
            return getText().toString();
        }
    }

    public void setMyanmarText(String text) {
        if(!TextUtils.isEmpty(text)) {
            setText(MyanTextProcessor.processText(getContext(), text));
        }
    }

}

