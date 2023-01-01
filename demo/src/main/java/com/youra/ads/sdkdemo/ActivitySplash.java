package com.youra.ads.sdkdemo;

import static com.youra.ads.sdk.util.Constant.ADMOB;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.youra.ads.sdk.format.AdNetwork;
import com.youra.ads.sdkdemo.database.AdsSharedPreferences;
import com.youra.ads.sdkdemo.utilis.Ads;
import com.youra.ads.sdkdemo.utilis.AdsManager;
import com.youra.ads.sdkdemo.utilis.Constant;

import java.util.Objects;

public class ActivitySplash extends AppCompatActivity {

    private static final long COUNTER_TIME = 2000;
    long secondsRemaining;
    Application application;
    AdsSharedPreferences sharedPreferences;
    AdsManager adsManager ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences = new AdsSharedPreferences(getApplication());
        adsManager = new AdsManager(this);
        adsManager.initAds();


        if (sharedPreferences.getValueString(Ads.AD_NETWORK).equals(ADMOB)) {
            application = getApplication();
            ((MyApplication) application).showAdIfAvailable(ActivitySplash.this, this::createTimer,sharedPreferences);
        } else {
            startMainActivity();
        }

        new Thread() {
            @Override
            public void run() {
                super.run();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child(Ads.DATABASE);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                            feedData(snapshot);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.d("TAG", "onCancelled: "+error.getMessage());
                    }

                });

            }


        }.start();

    }

    private void feedData(DataSnapshot snapshot) {

        if (snapshot.hasChild(Ads.AD_NETWORK)) {
            sharedPreferences.setValueString(Ads.AD_NETWORK, getValue(snapshot, Ads.AD_NETWORK));
        }

        if (snapshot.hasChild(Ads.AD_STATUS)) {
            sharedPreferences.setValueString(Ads.AD_STATUS, getValue(snapshot, Ads.AD_STATUS));
        }

        if (snapshot.hasChild(Ads.AD_TYPE)) {
            sharedPreferences.setValueString(Ads.AD_TYPE, getValue(snapshot, Ads.AD_TYPE));
        }

        if (snapshot.hasChild(Ads.BACKUP_AD_NETWORK)) {
            sharedPreferences.setValueString(Ads.BACKUP_AD_NETWORK, getValue(snapshot, Ads.BACKUP_AD_NETWORK));
        }

        if (snapshot.hasChild(Ads.AD_INTERSTITIAL_INTERVAL)) {
            sharedPreferences.setValueInt(Ads.AD_INTERSTITIAL_INTERVAL, Integer.parseInt( getValue(snapshot, Ads.AD_INTERSTITIAL_INTERVAL)));
        }

        ////admob
        if (snapshot.hasChild(Ads.UnityCode.APP_ID.getCodeAdmob())) {
            sharedPreferences.setValueString(Ads.UnityCode.APP_ID.getCodeAdmob(), getValue(snapshot, Ads.UnityCode.APP_ID.getCodeAdmob()));
         }
        if (snapshot.hasChild(Ads.UnityCode.OPEN_ID.getCodeAdmob())) {
            sharedPreferences.setValueString(Ads.UnityCode.OPEN_ID.getCodeAdmob(), getValue(snapshot, Ads.UnityCode.OPEN_ID.getCodeAdmob()));

        }
        if (snapshot.hasChild(Ads.UnityCode.BANNER_ID.getCodeAdmob())) {
            sharedPreferences.setValueString(Ads.UnityCode.BANNER_ID.getCodeAdmob(), getValue(snapshot, Ads.UnityCode.BANNER_ID.getCodeAdmob()));
        }
        if (snapshot.hasChild(Ads.UnityCode.INTERSTITIAL_ID.getCodeAdmob())) {
            sharedPreferences.setValueString(Ads.UnityCode.INTERSTITIAL_ID.getCodeAdmob(), getValue(snapshot, Ads.UnityCode.INTERSTITIAL_ID.getCodeAdmob()));
        }
        if (snapshot.hasChild(Ads.UnityCode.NATIVE_ID.getCodeAdmob())) {
            sharedPreferences.setValueString(Ads.UnityCode.NATIVE_ID.getCodeAdmob(), getValue(snapshot, Ads.UnityCode.NATIVE_ID.getCodeAdmob()));
        }

        ////fan
        if (snapshot.hasChild(Ads.UnityCode.OPEN_ID.getCodeFB())) {
            sharedPreferences.setValueString(Ads.UnityCode.OPEN_ID.getCodeFB(), getValue(snapshot, Ads.UnityCode.OPEN_ID.getCodeFB()));
        }
        if (snapshot.hasChild(Ads.UnityCode.BANNER_ID.getCodeFB())) {
            sharedPreferences.setValueString(Ads.UnityCode.BANNER_ID.getCodeFB(), getValue(snapshot, Ads.UnityCode.BANNER_ID.getCodeFB()));
        }
        if (snapshot.hasChild(Ads.UnityCode.INTERSTITIAL_ID.getCodeFB())) {
            sharedPreferences.setValueString(Ads.UnityCode.INTERSTITIAL_ID.getCodeFB(), getValue(snapshot, Ads.UnityCode.INTERSTITIAL_ID.getCodeFB()));
        }
        if (snapshot.hasChild(Ads.UnityCode.NATIVE_ID.getCodeFB())) {
            sharedPreferences.setValueString(Ads.UnityCode.NATIVE_ID.getCodeFB(), getValue(snapshot, Ads.UnityCode.NATIVE_ID.getCodeAdmob()));
        }

        //GAM
        if (snapshot.hasChild(Ads.UnityCode.OPEN_ID.getCodeGAM())) {
            sharedPreferences.setValueString(Ads.UnityCode.OPEN_ID.getCodeGAM(), getValue(snapshot, Ads.UnityCode.OPEN_ID.getCodeGAM()));
        }
        if (snapshot.hasChild(Ads.UnityCode.BANNER_ID.getCodeGAM())) {
            sharedPreferences.setValueString(Ads.UnityCode.BANNER_ID.getCodeGAM(), getValue(snapshot, Ads.UnityCode.BANNER_ID.getCodeGAM()));
        }
        if (snapshot.hasChild(Ads.UnityCode.INTERSTITIAL_ID.getCodeGAM())) {
            sharedPreferences.setValueString(Ads.UnityCode.INTERSTITIAL_ID.getCodeGAM(), getValue(snapshot, Ads.UnityCode.INTERSTITIAL_ID.getCodeGAM()));
        }
        if (snapshot.hasChild(Ads.UnityCode.NATIVE_ID.getCodeGAM())) {
            sharedPreferences.setValueString(Ads.UnityCode.NATIVE_ID.getCodeGAM(), getValue(snapshot, Ads.UnityCode.NATIVE_ID.getCodeAdmob()));
        }


    }

    public String getValue(DataSnapshot snapshot, String child) {
        Log.d("TAG", "feedData:  "+child+" "+Objects.requireNonNull(snapshot.child(child).getValue()).toString() );
        return Objects.requireNonNull(snapshot.child(child).getValue()).toString();
    }


    private void createTimer() {

        CountDownTimer countDownTimer = new CountDownTimer(COUNTER_TIME, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secondsRemaining = ((millisUntilFinished / 1000) + 1);
            }

            @Override
            public void onFinish() {
                secondsRemaining = 0;
                startMainActivity();
            }
        };
        countDownTimer.start();
    }

    public void startMainActivity() {
        this.startActivity(new Intent(this, MainActivity.class));
    }

}
