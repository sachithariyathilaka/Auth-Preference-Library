package com.sachith.authpreflibrary;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class AuthPreference {

    public static void authUserdata(Context context, int userId, boolean state){
        SharedPreferences sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("userId", userId);
        editor.putBoolean("status", state);
        editor.apply();
    }

    public static void saveUserHeaders(Context context, ArrayList<Headers> headers){
        SharedPreferences sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for(int i = 0; i < headers.size(); i++){
            editor.putString(headers.get(i).getHeader(), headers.get(i).getValue());
        }
        editor.apply();
    }

    public static Boolean getUserState(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("status", false);
    }

    public static int getUserId(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        return sharedPreferences.getInt("userId", 0);
    }

    public static ArrayList<Headers> getUserHeaders(Context context, ArrayList<String> headerNames){
        SharedPreferences sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        ArrayList<Headers> headers = new ArrayList<>();
        for(int j =0 ; j<headerNames.size(); j++){
            headers.add(new Headers(headerNames.get(j), sharedPreferences.getString(headerNames.get(j), "")));
        }
        return headers;
    }

}
