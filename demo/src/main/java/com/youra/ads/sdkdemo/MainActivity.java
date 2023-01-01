package com.youra.ads.sdkdemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.youra.ads.sdkdemo.utilis.AdsManager;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    AdsManager adsManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adsManager = new AdsManager(this);

        adsManager.initAds();
        adsManager.loadBannerAd();
        adsManager.loadInterstitialAd();
        adsManager.loadNativeAd();

        findViewById(R.id.btn_interstitial).setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), SecondActivity.class));
            adsManager.showInterstitialAd();
            adsManager.destroyBanner();
        });

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        adsManager.destroyBanner();
    }

    @Override
    public void onResume() {
        super.onResume();
        adsManager.loadBannerAd();
    }

}