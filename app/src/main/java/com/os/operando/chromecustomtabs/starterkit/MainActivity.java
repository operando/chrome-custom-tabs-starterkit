package com.os.operando.chromecustomtabs.starterkit;

import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import org.chromium.customtabsclient.shared.CustomTabsHelper;

public class MainActivity extends AppCompatActivity {

    private static final Uri URI = Uri.parse("https://www.android.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        CustomTabsIntent tabsIntent = new CustomTabsIntent.Builder().build();
        String packageName = CustomTabsHelper.getPackageNameToUse(this);
        tabsIntent.intent.setPackage(packageName);
        tabsIntent.launchUrl(this, getUri());
    }

    private Uri getUri() {
        String url = ((EditText) findViewById(R.id.url)).getText().toString();
        return TextUtils.isEmpty(url) ? URI : Uri.parse(url);
    }
}
