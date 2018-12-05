package com.koekoetech.androidcommonlibraryproject;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.koekoetech.androidcommonlibrary.common.BaseActivity;
import com.koekoetech.androidcommonlibrary.custom_control.MyanTextView;
import com.koekoetech.androidcommonlibrary.helper.FontSharePreferenceHelper;
import com.koekoetech.androidcommonlibrary.helper.TextDictionaryHelper;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.tv_version)
    MyanTextView tv_version;

    private FontSharePreferenceHelper fontSharePreferenceHelper;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected void setUpContents(Bundle savedInstanceState) {

        init();

        try {
            tv_version.setMyanmarText(TextDictionaryHelper.getText(this, TextDictionaryHelper.TEXT_VERSION) + " " + getVersionName());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void init()
    {
        setupToolbar(false);
        setupToolbarText("");
        getSupportActionBar().hide();

        fontSharePreferenceHelper = new FontSharePreferenceHelper(this);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                initProcess();

            }

        }, 1500);
    }

    private void initProcess()
    {
        if(fontSharePreferenceHelper.isLanguageFontSetup())
        {
            Intent intent = new Intent(this, MainActivity.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            }
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, LanguageActivity.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            }
            startActivity(intent);
        }
    }

    private String getVersionName() throws PackageManager.NameNotFoundException {
        PackageManager manager = this.getPackageManager();
        PackageInfo info = manager.getPackageInfo(
                this.getPackageName(), 0);

        return info.versionName;
    }

}
