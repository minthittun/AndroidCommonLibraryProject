package com.koekoetech.androidcommonlibrary.helper;

import android.app.Activity;

/**
 * Created by hello on 1/16/18.
 */

public class ActivityAnimationHelper {

    public static void setFadeInOutAnimation(Activity activity)
    {
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

}
