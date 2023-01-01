package com.youra.ads.sdkdemo.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.youra.ads.sdkdemo.utilis.Ads;

public class AdsSharedPreferences {

    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    public AdsSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("ads_setting", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveAds(String ad_status, String ad_type, String backup_ads, String admob_publisher_id, String admob_app_id, String admob_banner_unit_id, String admob_interstitial_unit_id, String admob_native_unit_id, String admob_app_open_ad_unit_id, String ad_manager_banner_unit_id, String ad_manager_interstitial_unit_id, String ad_manager_native_unit_id, String ad_manager_app_open_ad_unit_id, String startapp_app_id, String unity_game_id, String unity_banner_placement_id, String unity_interstitial_placement_id, int interstitial_ad_interval, int native_ad_interval, int native_ad_index) {
        editor.putString(Ads.AD_STATUS, ad_status);
        editor.putString("ad_type", ad_type);
        editor.putString(Ads.BACKUP_AD_NETWORK, backup_ads);
        editor.putString("admob_publisher_id", admob_publisher_id);

        editor.putString(Ads.UnityCode.APP_ID.getCodeAdmob(), admob_app_id);
        editor.putString(Ads.UnityCode.OPEN_ID.getCodeAdmob(), admob_app_open_ad_unit_id);
        editor.putString(Ads.UnityCode.BANNER_ID.getCodeAdmob(), admob_banner_unit_id);
        editor.putString(Ads.UnityCode.INTERSTITIAL_ID.getCodeAdmob(), admob_interstitial_unit_id);
        editor.putString(Ads.UnityCode.NATIVE_ID.getCodeAdmob(), admob_native_unit_id);

        editor.putString(Ads.UnityCode.OPEN_ID.getCodeGAM(), ad_manager_app_open_ad_unit_id);
        editor.putString(Ads.UnityCode.BANNER_ID.getCodeGAM(), ad_manager_banner_unit_id);
        editor.putString(Ads.UnityCode.INTERSTITIAL_ID.getCodeGAM(), ad_manager_interstitial_unit_id);
        editor.putString(Ads.UnityCode.NATIVE_ID.getCodeGAM(), ad_manager_native_unit_id);

        editor.putString("startapp_app_id", startapp_app_id);

        editor.putInt(Ads.AD_INTERSTITIAL_INTERVAL, interstitial_ad_interval);
        editor.putInt("native_ad_interval", native_ad_interval);
        editor.putInt("native_ad_index", native_ad_index);
        editor.apply();
    }

    public String getValueString(String key) {
        return sharedPreferences.getString(key, "0");
    }

    public void setValueString(String key, String value) {
        Log.d("TAG", "setValueString: key: "+key+",  value: "+value );
        editor.putString(key, value).apply();
    }

    public int getValueInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public void setValueInt(String key, Integer value) {
        editor.putInt(key, value).apply();
    }


}
