package com.example.android.directshare;
/* Connor D. Lyons Final Year Project UoG 2017/2018 iDetect CSVSample.java */
/* Class Source and Inspired By: Trustworthiness Monitor, paper: http://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=7965756 */
/* Class Source and Inspired By: https://www.youtube.com/watch?v=i-TqNzUryn8 */

//Class and private variable declarations
public class CSVSample {

    // Logistic regression hard-coded coefficients
    private static final double
            INTERCEPT = -1.559e+00,
            S3T = 8.567e-02,
            S3VIDEOS = -8.156e-02,
            S3WEBSITES = 2.712e-01,
            S2T = 1.893e-03,
            S2VIDEOS = -5.174e-01,
            S2GAME = -1.833e-01,
            S1T = 8.987e-02,
            S1COURSEWORK = -2.126e-01,
            FRPROVIDER = 2.119e-01,
            DRPROVIDER = 7.774e-03,
            FAPROVIDER = -9.746e-03,
            FRPLATFORM = 2.589e-02,
            DRPLATFORM = 9.875e-02,
            STPLATFORM = -7.232e-03,
            SA = 2.048e-05,
            CL = 8.463e-03;

    //CSV cell variable declarations
    private double s1t;
    private double s2t;
    private double s3t;
    private double s1coursework;
    private double s2videos;
    private double s2game;
    private double s3videos;
    private double s3websites;

    private double stemail;
    private double stim;
    private double stsocialmedia;
    private double stcloudstorage;
    private double stpublicwifi;
    private double stprivatewifi;
    private double stnfc;
    private double stecommerce;
    private double stpdfread;

    private double fafacebook;
    private double faqrcodes;
    private double facontactless;
    private double faschoolpublic;
    private double fagmail;
    private double facitypublic;
    private double fawhatsapp;
    private double faresidential;
    private double fafbmessenger;
    private double faworkprivate;
    private double faoutlook;
    private double fatwitter;
    private double facafepublic;
    private double faandroidsms;
    private double famailcom;
    private double fashopping;
    private double faandroidmail;
    private double fagoogledriveread;
    private double faworkpublicwifi;
    private double faschoolprivate;
    private double fagoogledrive;
    private double fadropbox;
    private double faonedrive;
    private double faamazon;
    private double faadobereader;
    private double faandroidreader;

    private double frsocialmedia;
    private double frnfc;
    private double frecommerce;
    private double fremail;
    private double frpublicwifi;
    private double frim;
    private double frcloud;
    private double frpdfreader;
    private double frprivatewifi;

    private double frfacebook;
    private double frqrcodes;
    private double frcontactless;
    private double frschoolpublic;
    private double frgmail;
    private double frcitypublic;
    private double frwhatsapp;
    private double frresidential;
    private double frfbmessenger;
    private double frworkprivate;
    private double froutlook;
    private double frtwitter;
    private double frcafepublic;
    private double frandroidsms;
    private double frmailcom;
    private double frshopping;
    private double frandroidmail;
    private double frgoogledriveread;
    private double frworkpublicwifi;
    private double frschoolprivate;
    private double frgoogledrive;
    private double frdropbox;
    private double fronedrive;
    private double framazon;
    private double fradobereader;
    private double frandroidreader;

    private double drsocialmedia;
    private double drnfc;
    private double drecommerce;
    private double dremail;
    private double drpublicwifi;
    private double drim;
    private double drcloud;
    private double drpdfreader;
    private double drprivatewifi;

    private double drfacebook;
    private double drqrcodes;
    private double drcontactless;
    private double drschoolpublic;
    private double drgmail;
    private double drcitypublic;
    private double drwhatsapp;
    private double drresidential;
    private double drfbmessenger;
    private double drworkprivate;
    private double droutlook;
    private double drtwitter;
    private double drcafepublic;
    private double drandroidsms;
    private double drmailcom;
    private double drshopping;
    private double drandroidmail;
    private double drgoogledriveread;
    private double drworkpublicwifi;
    private double drschoolprivate;
    private double drgoogledrive;
    private double drdropbox;
    private double dronedrive;
    private double dradobereader;
    private double drandroidreader;
    private double dramazon;

    private double sa;
    private double cl;

    //Class declaration
    public CSVSample() {
    }

    //Assigning cell references to variables
    public void setRainfall(double s1t) {
        this.s1t = s1t;
    }

    public void setSunHours(double s2t) {
        this.s2t = s2t;
    }

    public void setSunHours2(double s3t) {
        this.s3t = s3t;
    }

    public void setSunHours3(double s1coursework) {
        this.s1coursework = s1coursework;
    }

    public void setSunHours4(double s2game) {
        this.s2game = s2game;
    }

    public void setSunHours5(double s2videos) {
        this.s2videos = s2videos;
    }

    public void setSunHours6(double s3videos) {
        this.s3videos = s3videos;
    }

    public void setSunHours7(double s3websites) {
        this.s3websites = s3websites;
    }

    public void setSunHours8(double stemail) {
        this.stemail = stemail;
    }

    public void setSunHours9(double stim) {
        this.stim = stim;
    }

    public void setSunHours10(double stsocialmedia) {
        this.stsocialmedia = stsocialmedia;
    }

    public void setSunHours11(double stcloudstorage) {
        this.stcloudstorage = stcloudstorage;
    }

    public void setSunHours12(double stpublicwifi) {
        this.stpublicwifi = stpublicwifi;
    }

    public void setSunHours13(double stprivatewifi) {
        this.stprivatewifi = stprivatewifi;
    }

    public void setSunHours14(double stnfc) {
        this.stnfc = stnfc;
    }

    public void setSunHours15(double stpdfread) { this.stpdfread = stpdfread; }

    public void setSunHours16(double stecommerce) { this.stecommerce = stecommerce; }

    public void setSunHours17(double frsocialmedia) {
        this.frsocialmedia = frsocialmedia;
    }

    public void setSunHours18(double frnfc) {
        this.frnfc = frnfc;
    }

    public void setSunHours19(double fremail) {
        this.fremail = fremail;
    }

    public void setSunHours20(double frpublicwifi) {
        this.frpublicwifi = frpublicwifi;
    }

    public void setSunHours21(double frim) {
        this.frim = frim;
    }

    public void setSunHours22(double frcloud) {
        this.frcloud = frcloud;
    }

    public void setSunHours23(double frpdfreader) { this.frpdfreader = frpdfreader; }

    public void setSunHours24(double frprivatewifi) {
        this.frprivatewifi = frprivatewifi;
    }

    public void setSunHours25(double frecommerce) {
        this.frecommerce = frecommerce;
    }

    public void setSunHours26(double drsocialmedia) {
        this.drsocialmedia = drsocialmedia;
    }

    public void setSunHours27(double drnfc) {
        this.drnfc = drnfc;
    }

    public void setSunHours28(double dremail) {
        this.dremail = dremail;
    }

    public void setSunHours29(double drpublicwifi) {
        this.drpublicwifi = drpublicwifi;
    }

    public void setSunHours30(double drim) {
        this.drim = drim;
    }

    public void setSunHours31(double drcloud) {
        this.drcloud = drcloud;
    }

    public void setSunHours32(double drpdfreader) {
        this.drpdfreader = drpdfreader;
    }

    public void setSunHours33(double drprivatewifi) {
        this.drprivatewifi = drprivatewifi;
    }

    public void setSunHours34(double drecommerce) {
        this.drecommerce = drecommerce;
    }

    public void setSunHours35(double frfacebook) {
        this.frfacebook = frfacebook;
    }

    public void setSunHours36(double frqrcodes) { this.frqrcodes = frqrcodes; }

    public void setSunHours37(double frcontactless) {
        this.frcontactless = frcontactless;
    }

    public void setSunHours38(double frschoolpublic) {
        this.frschoolpublic = frschoolpublic;
    }

    public void setSunHours39(double frgmail) {
        this.frgmail = frgmail;
    }

    public void setSunHours40(double frcitypublic) {
        this.frcitypublic = frcitypublic;
    }

    public void setSunHours41(double frwhatsapp) {
        this.frwhatsapp = frwhatsapp;
    }

    public void setSunHours42(double frresidential) {
        this.frresidential = frresidential;
    }

    public void setSunHours43(double frfbmessenger) {
        this.frfbmessenger = frfbmessenger;
    }

    public void setSunHours44(double frworkprivate) {
        this.frworkprivate = frworkprivate;
    }

    public void setSunHours45(double froutlook) {
        this.froutlook = froutlook;
    }

    public void setSunHours46(double frtwitter) {
        this.frtwitter = frtwitter;
    }

    public void setSunHours47(double frcafepublic) {
        this.frcafepublic = frcafepublic;
    }

    public void setSunHours48(double frandroidsms) {
        this.frandroidsms = frandroidsms;
    }

    public void setSunHours49(double frmailcom) {
        this.frmailcom = frmailcom;
    }

    public void setSunHours50(double frshopping) {
        this.frshopping = frshopping;
    }

    public void setSunHours51(double frandroidmail) {
        this.frandroidmail = frandroidmail;
    }

    public void setSunHours52(double frgoogledriveread) { this.frgoogledriveread = frgoogledriveread; }

    public void setSunHours53(double frworkpublicwifi) { this.frworkpublicwifi = frworkpublicwifi; }

    public void setSunHours54(double frschoolprivate) { this.frschoolprivate = frschoolprivate; }

    public void setSunHours55(double frgoogledrive) {
        this.frgoogledrive = frgoogledrive;
    }

    public void setSunHours56(double frdropbox) {
        this.frdropbox = frdropbox;
    }

    public void setSunHours57(double fronedrive) {
        this.fronedrive = fronedrive;
    }

    public void setSunHours58(double fradobereader) {
        this.fradobereader = fradobereader;
    }

    public void setSunHours59(double frandroidreader) {
        this.frandroidreader = frandroidreader;
    }

    public void setSunHours60(double framazon) { this.framazon = framazon; }

    public void setSunHours61(double fafacebook) { this.fafacebook = fafacebook; }

    public void setSunHours62(double faqrcodes) { this.faqrcodes = faqrcodes; }

    public void setSunHours63(double facontactless) { this.facontactless = facontactless; }

    public void setSunHours64(double faschoolpublic) { this.faschoolpublic = faschoolpublic; }

    public void setSunHours65(double fagmail) { this.fagmail = fagmail; }

    public void setSunHours66(double facitypublic) { this.facitypublic = facitypublic; }

    public void setSunHours67(double fawhatsapp) { this.fawhatsapp = fawhatsapp; }

    public void setSunHours68(double faresidential) { this.faresidential = faresidential; }

    public void setSunHours69(double fafbmessenger) { this.fafbmessenger = fafbmessenger; }

    public void setSunHours70(double faworkprivate) { this.faworkprivate = faworkprivate; }

    public void setSunHours71(double faoutlook) { this.faoutlook = faoutlook; }

    public void setSunHours72(double fatwitter) { this.fatwitter = fatwitter; }

    public void setSunHours73(double facafepublic) { this.facafepublic = facafepublic; }

    public void setSunHours74(double faandroidsms) { this.faandroidsms = faandroidsms; }

    public void setSunHours75(double famailcom) { this.famailcom = famailcom; }

    public void setSunHours76(double fashopping) { this.fashopping = fashopping; }

    public void setSunHours77(double faandroidmail) { this.faandroidmail = faandroidmail; }

    public void setSunHours78(double fagoogledriveread) { this.fagoogledriveread = fagoogledriveread; }

    public void setSunHours79(double faworkpublicwifi) { this.faworkpublicwifi = faworkpublicwifi; }

    public void setSunHours80(double faschoolprivate) { this.faschoolprivate = faschoolprivate; }

    public void setSunHours81(double fagoogledrive) { this.fagoogledrive = fagoogledrive; }

    public void setSunHours82(double fadropbox) { this.fadropbox = fadropbox; }

    public void setSunHours83(double faonedrive) { this.faonedrive = faonedrive; }

    public void setSunHours84(double faadobereader) { this.faadobereader = faadobereader; }

    public void setSunHours85(double faandroidreader) { this.faandroidreader = faandroidreader; }

    public void setSunHours86(double faamazon) { this.faamazon = faamazon; }

    public void setSunHours87(double drfacebook) {
        this.drfacebook = drfacebook;
    }

    public void setSunHours88(double drqrcodes) {
        this.drqrcodes = drqrcodes;
    }

    public void setSunHours89(double drcontactless) {
        this.drcontactless = drcontactless;
    }

    public void setSunHours90(double drschoolpublic) {
        this.drschoolpublic = drschoolpublic;
    }

    public void setSunHours91(double drgmail) {
        this.drgmail = drgmail;
    }

    public void setSunHours92(double drcitypublic) {
        this.drcitypublic = drcitypublic;
    }

    public void setSunHours93(double drwhatsapp) {
        this.drwhatsapp = drwhatsapp;
    }

    public void setSunHours94(double drresidential) {
        this.drresidential = drresidential;
    }

    public void setSunHours95(double drfbmessenger) {
        this.drfbmessenger = drfbmessenger;
    }

    public void setSunHours96(double drworkprivate) {
        this.drworkprivate = drworkprivate;
    }

    public void setSunHours97(double droutlook) {
        this.droutlook = droutlook;
    }

    public void setSunHours98(double drtwitter) {
        this.drtwitter = drtwitter;
    }

    public void setSunHours99(double drcafepublic) {
        this.drcafepublic = drcafepublic;
    }

    public void setSunHours100(double drandroidsms) {
        this.drandroidsms = drandroidsms;
    }

    public void setSunHours101(double drmailcom) {
        this.drmailcom = drmailcom;
    }

    public void setSunHours102(double drshopping) {
        this.drshopping = drshopping;
    }

    public void setSunHours103(double drandroidmail) { this.drandroidmail = drandroidmail; }

    public void setSunHours104(double drgoogledriveread) { this.drgoogledriveread = drgoogledriveread; }

    public void setSunHours105(double drworkpublicwifi) { this.drworkpublicwifi = drworkpublicwifi; }

    public void setSunHours106(double drschoolprivate) {
        this.drschoolprivate = drschoolprivate;
    }

    public void setSunHours107(double drgoogledrive) {
        this.drgoogledrive = drgoogledrive;
    }

    public void setSunHours108(double drdropbox) {
        this.drdropbox = drdropbox;
    }

    public void setSunHours109(double dronedrive) {
        this.dronedrive = dronedrive;
    }

    public void setSunHours110(double dradobereader) { this.dradobereader = dradobereader; }

    public void setSunHours111(double drandroidreader) {
        this.drandroidreader = drandroidreader;
    }

    public void setSunHours112(double dramazon) { this.dramazon = dramazon; }

    public void setSunHours113(double sa) {
        this.sa = sa;
    }

    public void setSunHours114(double cl) {
        this.cl = cl;
    }

    public double calcTrustScore() {
        double sum = INTERCEPT +
                s3t;
       return sum;
    }

    //Logistic regression calculations for each platform type and platform
    @Override
    public String toString() {
        //WhatsApp
        double sum = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frwhatsapp * FRPROVIDER) + (drwhatsapp * DRPROVIDER) + (fawhatsapp * FAPROVIDER) + (frim * FRPLATFORM) + (drim * DRPLATFORM) + (stim * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore = (1 / (1 + Math.exp(-sum)));
        String numberAsString = String.format ("%,.2f", trustScore);
        return numberAsString;
    }

    public String toString2() {
        //FBMessenger
        double sum2 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frfbmessenger * FRPROVIDER) + (drfbmessenger * DRPROVIDER) + (fafbmessenger * FAPROVIDER) + (frim * FRPLATFORM) + (drim * DRPLATFORM) + (stim * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore2 = (1 / (1 + Math.exp(-sum2)));
        String numberAsString2 = String.format ("%,.2f", trustScore2);
        return numberAsString2;
    }

    public String toString3() {
        //SMS
        double sum3 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (drandroidsms * FRPROVIDER) + (drandroidsms * DRPROVIDER) + (faandroidsms * FAPROVIDER) + (frim * FRPLATFORM) + (drim * DRPLATFORM) + (stim * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore3 = (1 / (1 + Math.exp(-sum3)));
        String numberAsString3 = String.format ("%,.2f", trustScore3);
        return numberAsString3;
    }

    public String toString4() {
        //Facebook
        double sum4 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frfacebook * FRPROVIDER) + (drfacebook * DRPROVIDER) + (fafacebook * FAPROVIDER) + (frsocialmedia * FRPLATFORM) + (drsocialmedia * DRPLATFORM) + (stsocialmedia * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore4 = (1 / (1 + Math.exp(-sum4)));
        String numberAsString4 = String.format ("%,.2f", trustScore4);
        return numberAsString4;
    }

    public String toString6() {
        //Twitter
        double sum6 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frtwitter * FRPROVIDER) + (drtwitter * DRPROVIDER) + (fatwitter * FAPROVIDER) + (drsocialmedia * FRPLATFORM) + (drsocialmedia * DRPLATFORM) + (stsocialmedia * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore6 = (1 / (1 + Math.exp(-sum6)));
        String numberAsString6 = String.format ("%,.2f", trustScore6);
        return numberAsString6;
    }

    public String toString7() {
        //QRCodes
        double sum7 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frqrcodes * FRPROVIDER) + (drqrcodes * DRPROVIDER) + (faqrcodes * FAPROVIDER) + (frnfc * FRPLATFORM) + (drnfc * DRPLATFORM) + (stnfc * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore7 = (1 / (1 + Math.exp(-sum7)));
        String numberAsString7 = String.format ("%,.2f", trustScore7);
        return numberAsString7;
    }

    public String toString9() {
        //Contactless (Cards/Mobile)
        double sum9 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frcontactless * FRPROVIDER) + (drcontactless * DRPROVIDER) + (facontactless * FAPROVIDER) + (frnfc * FRPLATFORM) + (drnfc * DRPLATFORM) + (stnfc * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore9 = (1 / (1 + Math.exp(-sum9)));
        String numberAsString9 = String.format ("%,.2f", trustScore9);
        return numberAsString9;
    }

    public String toString10() {
        //Gmail
        double sum10 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frgmail * FRPROVIDER) + (drgmail * DRPROVIDER) + (fagmail * FAPROVIDER) + (fremail * FRPLATFORM) + (dremail * DRPLATFORM) + (stemail * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore10 = (1 / (1 + Math.exp(-sum10)));
        String numberAsString10 = String.format ("%,.2f", trustScore10);
        return numberAsString10;
    }

    public String toString11() {
        //Outlook
        double sum11 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (froutlook * FRPROVIDER) + (droutlook * DRPROVIDER) + (faoutlook * FAPROVIDER) + (fremail * FRPLATFORM) + (dremail * DRPLATFORM) + (stemail * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore11 = (1 / (1 + Math.exp(-sum11)));
        String numberAsString11 = String.format ("%,.2f", trustScore11);
        return numberAsString11;
    }

    public String toString12() {
        //Mail.com
        double sum12 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frmailcom * FRPROVIDER) + (drmailcom * DRPROVIDER) + (famailcom * FAPROVIDER) + (fremail * FRPLATFORM) + (dremail * DRPLATFORM) + (stemail * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore12 = (1 / (1 + Math.exp(-sum12)));
        String numberAsString12 = String.format ("%,.2f", trustScore12);
        return numberAsString12;
    }

    public String toString13() {
        //Android Mail
        double sum13 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frandroidmail * FRPROVIDER) + (drandroidmail * DRPROVIDER) + (faandroidmail * FAPROVIDER) + (fremail * FRPLATFORM) + (dremail * DRPLATFORM) + (stemail * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore13 = (1 / (1 + Math.exp(-sum13)));
        String numberAsString13 = String.format ("%,.2f", trustScore13);
        return numberAsString13;
    }

    public String toString14() {
        //Google Drive
        double sum14 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frgoogledrive * FRPROVIDER) + (drgoogledrive * DRPROVIDER) + (fagoogledrive * FAPROVIDER) + (frcloud * FRPLATFORM) + (drcloud * DRPLATFORM) + (stcloudstorage * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore14 = (1 / (1 + Math.exp(-sum14)));
        String numberAsString14 = String.format ("%,.2f", trustScore14);
        return numberAsString14;
    }

    public String toString15() {
        //Dropbox
        double sum15 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frdropbox * FRPROVIDER) + (drdropbox * DRPROVIDER) + (fadropbox * FAPROVIDER) + (frcloud * FRPLATFORM) + (drcloud * DRPLATFORM) + (stcloudstorage * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore15 = (1 / (1 + Math.exp(-sum15)));
        String numberAsString15 = String.format ("%,.2f", trustScore15);
        return numberAsString15;
    }

    public String toString16() {
        //OneDrive
        double sum16 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (fronedrive * FRPROVIDER) + (dronedrive * DRPROVIDER) + (faonedrive * FAPROVIDER) + (frcloud * FRPLATFORM) + (drcloud * DRPLATFORM) + (stcloudstorage * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore16 = (1 / (1 + Math.exp(-sum16)));
        String numberAsString16 = String.format ("%,.2f", trustScore16);
        return numberAsString16;
    }

    public String toString17() {
        //Adobe Reader
        double sum17 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (fradobereader * FRPROVIDER) + (dradobereader * DRPROVIDER) + (faadobereader * FAPROVIDER) + (frpdfreader * FRPLATFORM) + (drpdfreader * DRPLATFORM) + (stpdfread * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore17 = (1 / (1 + Math.exp(-sum17)));
        String numberAsString17 = String.format ("%,.2f", trustScore17);
        return numberAsString17;
    }

    public String toString18() {
        //Google Drive Reader
        double sum18 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frgoogledriveread * FRPROVIDER) + (drgoogledriveread * DRPROVIDER) + (fagoogledriveread * FAPROVIDER) + (frpdfreader * FRPLATFORM) + (drpdfreader * DRPLATFORM) + (stpdfread * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore18 = (1 / (1 + Math.exp(-sum18)));
        String numberAsString18 = String.format ("%,.2f", trustScore18);
        return numberAsString18;
    }

    public String toString19() {
        //Android Reader
        double sum19 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frandroidreader * FRPROVIDER) + (drandroidreader * DRPROVIDER) + (faandroidreader * FAPROVIDER) + (frpdfreader * FRPLATFORM) + (drpdfreader * DRPLATFORM) + (stpdfread * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore19 = (1 / (1 + Math.exp(-sum19)));
        String numberAsString19 = String.format ("%,.2f", trustScore19);
        return numberAsString19;
    }

    public String toString20() {
        //Cafe
        double sum20 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frcafepublic * FRPROVIDER) + (drcafepublic * DRPROVIDER) + (facafepublic * FAPROVIDER) + (frpublicwifi * FRPLATFORM) + (drpublicwifi * DRPLATFORM) + (stpublicwifi * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore20 = (1 / (1 + Math.exp(-sum20)));
        String numberAsString20 = String.format ("%,.2f", trustScore20);
        return numberAsString20;
    }

    public String toString21() {
        //Shopping Centre
        double sum21 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frshopping * FRPROVIDER) + (drshopping * DRPROVIDER) + (fashopping * FAPROVIDER) + (frpublicwifi * FRPLATFORM) + (drpublicwifi * DRPLATFORM) + (stpublicwifi * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore21 = (1 / (1 + Math.exp(-sum21)));
        String numberAsString21 = String.format ("%,.2f", trustScore21);
        return numberAsString21;
    }

    public String toString22() {
        //City Hotspot
        double sum22 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frcitypublic * FRPROVIDER) + (drcitypublic * DRPROVIDER) + (facitypublic * FAPROVIDER) + (frpublicwifi * FRPLATFORM) + (drpublicwifi * DRPLATFORM) + (stpublicwifi * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore22 = (1 / (1 + Math.exp(-sum22)));
        String numberAsString22 = String.format ("%,.2f", trustScore22);
        return numberAsString22;
    }

    public String toString23() {
        //Residential Hotspot
        double sum23 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frresidential * FRPROVIDER) + (drresidential * DRPROVIDER) + (faresidential * FAPROVIDER) + (frpublicwifi * FRPLATFORM) + (drpublicwifi * DRPLATFORM) + (stpublicwifi * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore23 = (1 / (1 + Math.exp(-sum23)));
        String numberAsString23 = String.format ("%,.2f", trustScore23);
        return numberAsString23;
    }

    public String toString24() {
        //School/College
        double sum24 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frschoolpublic * FRPROVIDER) + (drschoolpublic * DRPROVIDER) + (faschoolpublic * FAPROVIDER) + (frpublicwifi * FRPLATFORM) + (drpublicwifi * DRPLATFORM) + (stpublicwifi * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore24 = (1 / (1 + Math.exp(-sum24)));
        String numberAsString24 = String.format ("%,.2f", trustScore24);
        return numberAsString24;
    }

    public String toString25() {
        //Work
        double sum25 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frworkpublicwifi * FRPROVIDER) + (drworkpublicwifi * DRPROVIDER) + (faworkpublicwifi * FAPROVIDER) + (frpublicwifi * FRPLATFORM) + (drpublicwifi * DRPLATFORM) + (stpublicwifi * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore25 = (1 / (1 + Math.exp(-sum25)));
        String numberAsString25 = String.format ("%,.2f", trustScore25);
        return numberAsString25;
    }

    public String toString26() {
        //Work
        double sum26 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frworkprivate * FRPROVIDER) + (drworkprivate * DRPROVIDER) + (faworkprivate * FAPROVIDER) + (frprivatewifi * FRPLATFORM) + (drprivatewifi * DRPLATFORM) + (stprivatewifi * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore26 = (1 / (1 + Math.exp(-sum26)));
        String numberAsString26 = String.format ("%,.2f", trustScore26);
        return numberAsString26;
    }

    public String toString27() {
        //School/College
        double sum27 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (frschoolprivate * FRPROVIDER) + (drschoolprivate * DRPROVIDER) + (faschoolprivate * FAPROVIDER) + (frprivatewifi * FRPLATFORM) + (drprivatewifi * DRPLATFORM) + (stprivatewifi * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore27 = (1 / (1 + Math.exp(-sum27)));
        String numberAsString27 = String.format ("%,.2f", trustScore27);
        return numberAsString27;
    }

    public String toString28() {
        //Amazon
        double sum27 = INTERCEPT + (s1t * S1T) + (s2t * S2T) + (s3t * S3T) + (s1coursework * S1COURSEWORK) + (s2videos * S2VIDEOS) + (s2game * S2GAME) + (s3videos * S3VIDEOS) + (s3websites * S3WEBSITES) + (framazon * FRPROVIDER) + (dramazon * DRPROVIDER) + (faamazon * FAPROVIDER) + (frecommerce * FRPLATFORM) + (drecommerce * DRPLATFORM) + (stecommerce * STPLATFORM) + (sa * SA) + (cl * CL);
        double trustScore27 = (1 / (1 + Math.exp(-sum27)));
        String numberAsString27 = String.format ("%,.2f", trustScore27);
        return numberAsString27;
    }
}