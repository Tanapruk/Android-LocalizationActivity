package com.akexorcist.localizationapp.customactivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.akexorcist.localizationactivity.LocalizationDelegate;
import com.akexorcist.localizationactivity.OnLocaleChangedListener;

import java.util.Locale;

/**
 * Created by Akexorcist on 6/23/16 AD.
 */
public abstract class CustomActivity extends Activity implements OnLocaleChangedListener {

    private LocalizationDelegate localizationDelegate = new LocalizationDelegate(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        localizationDelegate.addOnLocaleChangedListener(this);
        localizationDelegate.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        localizationDelegate.onResume();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(localizationDelegate.attachBaseContext(newBase));
    }

    public final void setLanguage(String language) {
        localizationDelegate.setLanguage(language);
    }

    public final void setLanguage(String language, String country) {
        localizationDelegate.setLanguage(language, country);
    }

    public final void setLanguage(Locale locale) {
        localizationDelegate.setLanguage(locale);
    }

    public final void setDefaultLanguage(String language) {
        localizationDelegate.setDefaultLanguage(language);
    }

    public final void setDefaultLanguage(String language, String country) {
        localizationDelegate.setDefaultLanguage(language, country);
    }

    public final void setDefaultLanguage(Locale locale) {
        localizationDelegate.setDefaultLanguage(locale);
    }

    public final Locale getLanguage() {
        return localizationDelegate.getLanguage();
    }

    // Just override method locale change event
    @Override
    public void onBeforeLocaleChanged() {
    }

    @Override
    public void onAfterLocaleChanged() {
    }
}
