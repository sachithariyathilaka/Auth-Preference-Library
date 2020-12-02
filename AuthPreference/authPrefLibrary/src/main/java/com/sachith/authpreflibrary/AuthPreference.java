package com.sachith.authpreflibrary;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class AuthPreference {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private void authUserdata(Context context, int userId, boolean state){
        sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt("userId", userId);
        editor.putBoolean("status", state);
        editor.apply();
    }

    private void saveUserHeaders(Context context, ArrayList<Headers> headers){
        sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        for(int i = 0; i < headers.size(); i++){
            editor.putString(headers.get(i).getHeader(), headers.get(i).getValue());
        }
        editor.apply();
    }

    private Boolean getUserState(Context context){
        sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("status", false);
    }

    private int getUserId(Context context){
        sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        return sharedPreferences.getInt("userId", 0);
    }

    private ArrayList<Headers> getUserHeaders(Context context, ArrayList<String> headerNames){
        sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        ArrayList<Headers> headers = new ArrayList<>();
        for(int j =0 ; j<headerNames.size(); j++){
            headers.add(new Headers(headerNames.get(j), sharedPreferences.getString(headerNames.get(j), "")));
        }
        return headers;
    }

}
