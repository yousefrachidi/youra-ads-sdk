package com.youra.ads.sdkdemo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.youra.ads.sdk.format.BannerAd;
import com.youra.ads.sdk.format.NativeAd;
import com.youra.ads.sdkdemo.utilis.AdsManager;
import com.youra.ads.sdkdemo.utilis.Constant;

public class SecondActivity extends AppCompatActivity {

    Toolbar toolbar;
    AdsManager adsManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        adsManager = new AdsManager(this);
        adsManager.loadBannerAd();
        adsManager.loadNativeSmallAd();
        initToolbar();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        adsManager.destroyBanner();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
