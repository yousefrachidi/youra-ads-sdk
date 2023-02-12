package com.youra.ads.sdkdemo.utilis;

public class Ads {

    public static String DATABASE = "MultipleAds";

    public static String AD_NETWORK = "AD_NETWORK";
    public static String AD_STATUS = "AD_STATUS";
    public static String AD_TYPE = "AD_TYPE";
    public static String TOKEN_FAN = "TOKEN_FAN";
    public static String BACKUP_AD_NETWORK = "BACKUP_AD_NETWORK";

    public static String AD_INTERSTITIAL_INTERVAL = "AD_INTERSTITIAL_INTERVAL";

    public enum UnityCode {

        APP_ID("ADMOB_APP_ID", "ADMOB_APP_ID","GAM_APP_ID") ,
        OPEN_ID("ADMOB_OPEN_ID", "FAN_OPEN_ID","GAM_OPEN_ID") ,
        BANNER_ID("ADMOB_BANNER_ID", "FAN_BANNER_ID","GAM_BANNER_ID")  ,
        INTERSTITIAL_ID("ADMOB_INTERSTITIAL_ID","FAN_INTERSTITIAL_ID","GAM_INTERSTITIAL_ID") ,
        NATIVE_ID("ADMOB_NATIVE_ID","FAN_NATIVE_ID","GAM_NATIVE_ID") ;


        private String codeAdmob;
        private String codeFB;
        private String codeGAM;

        UnityCode(String codeAdmob, String codeFB, String codeManger) {
            this.codeAdmob = codeAdmob;
            this.codeFB = codeFB;
            this.codeGAM = codeManger;
        }

        public String getCodeFB() {
            return codeFB;
        }

        public void setCodeFB(String codeFB) {
            this.codeFB = codeFB;
        }

        public String getCodeAdmob() {
            return codeAdmob;
        }

        public void setCodeAdmob(String codeAdmob) {
            this.codeAdmob = codeAdmob;
        }

        public String getCodeGAM() {
            return codeGAM;
        }

        public void setCodeGAM(String codeGAM) {
            this.codeGAM = codeGAM;
        }
    }







}
