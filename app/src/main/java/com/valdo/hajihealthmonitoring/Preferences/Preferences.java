package com.valdo.hajihealthmonitoring.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    /** Pendeklarasian key-data berupa String, untuk sebagai wadah penyimpanan data.
     * Jadi setiap data mempunyai key yang berbeda satu sama lain */
    static final String KEY_IBU_TEREGISTER ="ibu", KEY_BAYI_TEREGISTER ="bayi",KEY_TTL_TEREGISTER="ttl" ;
    static final String KEY_USERNAME_SEDANG_LOGIN = "Username_logged_in";
    static final String KEY_STATUS_SEDANG_LOGIN = "Status_logged_in";

    /** Pendlakarasian Shared Preferences yang berdasarkan paramater context */
    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /** Deklarasi Edit Preferences dan mengubah data
     *  yang memiliki key isi KEY_USER_TEREGISTER dengan parameter username */
    public static void setRegisteredIbu(Context context, String namaIbu){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_IBU_TEREGISTER, namaIbu);
        editor.apply();
    }


    /** Mengembalikan nilai dari key KEY_USER_TEREGISTER berupa String */
    public static String getRegisteredIbu(Context context){
        return getSharedPreference(context).getString(KEY_IBU_TEREGISTER,"");
    }
     public static void setRegisteredBayi(Context context, String namaBayi){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_BAYI_TEREGISTER, namaBayi);
        editor.apply();
    }


    /** Mengembalikan nilai dari key KEY_USER_TEREGISTER berupa String */
    public static String getRegisteredBayi(Context context){
        return getSharedPreference(context).getString(KEY_BAYI_TEREGISTER,"");
    }

    public static void setRegisteredTtl(Context context, String ttl){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_TTL_TEREGISTER, ttl);
        editor.apply();
    }


    /** Mengembalikan nilai dari key KEY_USER_TEREGISTER berupa String */
    public static String getRegisteredTtl(Context context){
        return getSharedPreference(context).getString(KEY_TTL_TEREGISTER,"");
    }

    /** Deklarasi Edit Preferences dan mengubah data
     *  yang memiliki key KEY_PASS_TEREGISTER dengan parameter password */
//    public static void setRegisteredPass(Context context, String password){
//        SharedPreferences.Editor editor = getSharedPreference(context).edit();
//        editor.putString(KEY_PASS_TEREGISTER, password);
//        editor.apply();
//    }
//    /** Mengembalikan nilai dari key KEY_PASS_TEREGISTER berupa String */
//    public static String getRegisteredPass(Context context){
//        return getSharedPreference(context).getString(KEY_PASS_TEREGISTER,"");
//    }

    /** Deklarasi Edit Preferences dan mengubah data
     *  yang memiliki key KEY_USERNAME_SEDANG_LOGIN dengan parameter username */
    public static void setLoggedInUser(Context context, String username){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_USERNAME_SEDANG_LOGIN, username);
        editor.apply();
    }
    /** Mengembalikan nilai dari key KEY_USERNAME_SEDANG_LOGIN berupa String */
    public static String getLoggedInUser(Context context){
        return getSharedPreference(context).getString(KEY_USERNAME_SEDANG_LOGIN,"");
    }

    /** Deklarasi Edit Preferences dan mengubah data
     *  yang memiliki key KEY_STATUS_SEDANG_LOGIN dengan parameter status */
    public static void setLoggedInStatus(Context context, boolean status){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(KEY_STATUS_SEDANG_LOGIN,status);
        editor.apply();
    }
    /** Mengembalikan nilai dari key KEY_STATUS_SEDANG_LOGIN berupa boolean */
    public static boolean getLoggedInStatus(Context context){
        return getSharedPreference(context).getBoolean(KEY_STATUS_SEDANG_LOGIN,false);
    }

    /** Deklarasi Edit Preferences dan menghapus data, sehingga menjadikannya bernilai default
     *  khusus data yang memiliki key KEY_USERNAME_SEDANG_LOGIN dan KEY_STATUS_SEDANG_LOGIN */
    public static void clearLoggedInUser (Context context){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.remove(KEY_USERNAME_SEDANG_LOGIN);
        editor.remove(KEY_STATUS_SEDANG_LOGIN);
        editor.apply();
    }

}
