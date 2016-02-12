package com.os.operando.chromecustomtabs.starterkit;

import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.chromium.customtabsclient.shared.CustomTabsHelper;

public class MainActivity extends AppCompatActivity {

    private static final Uri URI = Uri.parse("https://developer.chrome.com/multidevice/android/customtabs");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        CustomTabsIntent tabsIntent = new CustomTabsIntent.Builder().build();
        String packageName = CustomTabsHelper.getPackageNameToUse(this);
        tabsIntent.intent.setPackage(packageName);
        tabsIntent.launchUrl(this, URI);
    }
}
