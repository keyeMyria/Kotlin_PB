package com.megoapp.data.storage;


import android.content.SharedPreferences;

public class Storage {

    private final SharedPreferences sharedPreferences;

    public Storage(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void setValue(String key, String val) {
        sharedPreferences.edit()
                .putString(key, val)
                .commit();
    }

    public String getValue(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void setInt(String key, Integer val) {
        sharedPreferences.edit()
                .putInt(key, val)
                .commit();
    }

    public Integer getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

}
