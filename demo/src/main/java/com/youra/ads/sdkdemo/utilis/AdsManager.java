package com.youra.ads.sdkdemo.utilis;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.youra.ads.sdk.format.AdNetwork;
import com.youra.ads.sdk.format.BannerAd;
import com.youra.ads.sdk.format.InterstitialAd;
import com.youra.ads.sdk.format.MediumRectangleAd;
import com.youra.ads.sdk.format.NativeAd;
import com.youra.ads.sdk.format.NativeAdFragment;

import com.youra.ads.sdkdemo.BuildConfig;
import com.youra.ads.sdkdemo.R;
import com.youra.ads.sdkdemo.database.AdsSharedPreferences;

public class AdsManager {

    private final Activity activity;
    private final AdsSharedPreferences pref;
    AdNetwork.Initialize adNetwork;
    BannerAd.Builder bannerAd;
    MediumRectangleAd.Builder mediumRectangleAd;
    InterstitialAd.Builder interstitialAd;
    NativeAd.Builder nativeAd;
    NativeAd.Builder nativeSamllAd;
    NativeAdFragment.Builder nativeAdView;

    public AdsManager(Activity activity) {
        this.activity = activity;
        adNetwork = new AdNetwork.Initialize(activity);
        bannerAd = new BannerAd.Builder(activity);
        interstitialAd = new InterstitialAd.Builder(activity);
        nativeAd = new NativeAd.Builder(activity);
        nativeAdView = new NativeAdFragment.Builder(activity);
        pref = new AdsSharedPreferences(activity);
    }


    public void initAds() {
        setId(pref.getValueString(Ads.UnityCode.APP_ID.getCodeAdmob()));
        adNetwork = new AdNetwork.Initialize(activity)
                .setAdStatus(pref.getValueString(Ads.AD_STATUS))
                .setAdNetwork(pref.getValueString(Ads.AD_NETWORK))
                .setBackupAdNetwork(pref.getValueString(Ads.BACKUP_AD_NETWORK))
                .setAdMobAppId(pref.getValueString(Ads.UnityCode.APP_ID.getCodeAdmob()))
                .setStartappAppId(Constant.STARTAPP_APP_ID)
                .setUnityGameId(Constant.UNITY_GAME_ID)
                .setAppLovinSdkKey(activity.getResources().getString(R.string.applovin_sdk_key))
                .setIronSourceAppKey(Constant.IRONSOURCE_APP_KEY)
                .setDebug(BuildConfig.DEBUG)
                .build();
    }

    private void setId(String id) {
        try {
            ApplicationInfo ai = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            ai.metaData.putString("com.google.android.gms.ads.APPLICATION_ID", id);
            String ApiKey = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
            Log.d("setId", "getId: " + ApiKey);
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
        }
    }

    public void loadBannerAd() {
        bannerAd = new BannerAd.Builder(activity)
                .setAdStatus(pref.getValueString(Ads.AD_STATUS))
                .setAdNetwork(pref.getValueString(Ads.AD_NETWORK))
                .setBackupAdNetwork(pref.getValueString(Ads.BACKUP_AD_NETWORK))
                .setAdMobBannerId(pref.getValueString(Ads.UnityCode.BANNER_ID.getCodeAdmob()))
                .setGoogleAdManagerBannerId(Ads.UnityCode.BANNER_ID.getCodeGAM())
                .setFanBannerId(pref.getValueString(Ads.UnityCode.BANNER_ID.getCodeFB()))
                .setUnityBannerId(Constant.UNITY_BANNER_ID)
                .setAppLovinBannerId(Constant.APPLOVIN_BANNER_ID)
                .setAppLovinBannerZoneId(Constant.APPLOVIN_BANNER_ZONE_ID)
                .setIronSourceBannerId(Constant.IRONSOURCE_BANNER_ID)
                .setDarkTheme(false)
                .build();
    }

    public void destroyBanner() {
        bannerAd.destroyAndDetachBanner();
    }

    public void loadInterstitialAd() {
        interstitialAd = new InterstitialAd.Builder(activity)
                .setAdStatus(pref.getValueString(Ads.AD_STATUS))
                .setAdNetwork(pref.getValueString(Ads.AD_NETWORK))
                .setBackupAdNetwork(pref.getValueString(Ads.BACKUP_AD_NETWORK))
                .setAdMobInterstitialId(pref.getValueString(Ads.UnityCode.INTERSTITIAL_ID.getCodeAdmob()))
                .setGoogleAdManagerInterstitialId(pref.getValueString(Ads.UnityCode.INTERSTITIAL_ID.getCodeGAM()))
                .setFanInterstitialId(pref.getValueString(Ads.UnityCode.INTERSTITIAL_ID.getCodeFB()))
                .setUnityInterstitialId(Constant.UNITY_INTERSTITIAL_ID)
                .setAppLovinInterstitialId(Constant.APPLOVIN_INTERSTITIAL_ID)
                .setAppLovinInterstitialZoneId(Constant.APPLOVIN_INTERSTITIAL_ZONE_ID)
                .setIronSourceInterstitialId(Constant.IRONSOURCE_INTERSTITIAL_ID)
                .setInterval(1)
                .build();
    }

    public void showInterstitialAd() {
        interstitialAd.show();
    }

    public void loadNativeAd() {
        nativeAd = new NativeAd.Builder(activity)
                .setAdStatus(pref.getValueString(Ads.AD_STATUS))
                .setAdNetwork(pref.getValueString(Ads.AD_NETWORK))
                .setBackupAdNetwork(pref.getValueString(Ads.BACKUP_AD_NETWORK))
                .setAdMobNativeId(pref.getValueString(Ads.UnityCode.NATIVE_ID.getCodeAdmob()))
                .setAdManagerNativeId(pref.getValueString(Ads.UnityCode.NATIVE_ID.getCodeGAM()))
                .setFanNativeId(pref.getValueString(Ads.UnityCode.NATIVE_ID.getCodeFB()))
                .setAppLovinNativeId(Constant.APPLOVIN_NATIVE_MANUAL_ID)
                .setNativeAdStyle(Constant.STYLE_VIDEO_LARGE)
                .setDarkTheme(false)
                .build();
    }

    public void loadMediumRectangleAd() {
        mediumRectangleAd = new MediumRectangleAd.Builder(activity)
                .setAdStatus(pref.getValueString(Ads.AD_STATUS))
                .setAdNetwork(pref.getValueString(Ads.AD_NETWORK))
                .setBackupAdNetwork(pref.getValueString(Ads.BACKUP_AD_NETWORK))
                .setAdMobBannerId(Constant.ADMOB_BANNER_ID)
                .setGoogleAdManagerBannerId(Constant.GOOGLE_AD_MANAGER_BANNER_ID)
                .setFanBannerId(Constant.FAN_BANNER_ID)
                .setUnityBannerId(Constant.UNITY_BANNER_ID)
                .setAppLovinBannerId(Constant.APPLOVIN_BANNER_ID)
                .setAppLovinBannerZoneId(Constant.APPLOVIN_BANNER_ZONE_ID)
                .setIronSourceBannerId(Constant.IRONSOURCE_BANNER_ID)
                .setDarkTheme(false)
                .build();
    }


    public void loadNativeSmallAd() {
        nativeSamllAd = new NativeAd.Builder(activity)
                .setAdStatus(pref.getValueString(Ads.AD_STATUS))
                .setAdNetwork(pref.getValueString(Ads.AD_NETWORK))
                .setBackupAdNetwork(pref.getValueString(Ads.BACKUP_AD_NETWORK))
                .setAdMobNativeId(pref.getValueString(Ads.UnityCode.NATIVE_ID.getCodeAdmob()))
                .setAdManagerNativeId(pref.getValueString(Ads.UnityCode.NATIVE_ID.getCodeGAM()))
                .setFanNativeId(pref.getValueString(Ads.UnityCode.NATIVE_ID.getCodeFB()))
                .setNativeAdStyle(Constant.STYLE_VIDEO_SMALL)
                .setDarkTheme(false)
                .build();

    }


}
