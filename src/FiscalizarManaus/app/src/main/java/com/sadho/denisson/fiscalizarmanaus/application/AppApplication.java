package com.sadho.denisson.fiscalizarmanaus.application;

import android.app.Application;
import android.content.Context;

import com.orm.SugarContext;

public class AppApplication extends Application {

    private static Context sContext;
    private static AppApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        synchronized (AppApplication.class) {
            if (sContext == null) {
                sContext = getApplicationContext();
            }
            if (sInstance == null) {
                sInstance = this;
            }

            SugarContext.init(this);
        }
    }
}
