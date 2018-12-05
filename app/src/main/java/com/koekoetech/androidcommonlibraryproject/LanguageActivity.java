package com.koekoetech.androidcommonlibraryproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.koekoetech.androidcommonlibrary.common.BaseActivity;
import com.koekoetech.androidcommonlibrary.helper.AndroidCommonConstant;
import com.koekoetech.androidcommonlibrary.helper.AndroidCommonSetup;
import com.koekoetech.androidcommonlibrary.helper.FontSharePreferenceHelper;

import butterknife.BindView;

public class LanguageActivity extends BaseActivity {

    private FontSharePreferenceHelper sharePreferenceHelper;

    @BindView(R.id.rd_language)
    RadioGroup rdlanguage;

    @BindView(R.id.rd_english)
    RadioButton rd_english;
    @BindView(R.id.rd_myanmar)
    RadioButton rd_myanmar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_language;
    }

    @Override
    protected void setUpContents(Bundle savedInstanceState) {

        init();

        if(sharePreferenceHelper.getLanguage().equals(AndroidCommonConstant.MYANMAR_LANGUAGE))
        {
            rd_myanmar.setChecked(true);
        }
        else if(sharePreferenceHelper.getLanguage().equals(AndroidCommonConstant.ENGLISH_LANGUAGE))
        {
            rd_english.setChecked(true);
        }
        else
        {
            rd_myanmar.setChecked(false);
            rd_english.setChecked(false);
        }

        rdlanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rd_english:
                        AndroidCommonSetup.getInstance().changeLanguage(AndroidCommonConstant.ENGLISH_LANGUAGE);
                        //showFont();
                        initProcess();
                        break;
                    case R.id.rd_myanmar:
                        AndroidCommonSetup.getInstance().changeLanguage(AndroidCommonConstant.MYANMAR_LANGUAGE);
                        //showFont();
                        initProcess();
                        break;
                }
            }
        });

    }

    private void init()
    {
        setupToolbar(true);
        setupToolbarText("Language");

        sharePreferenceHelper = new FontSharePreferenceHelper(this);
    }

    private void initProcess()
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
