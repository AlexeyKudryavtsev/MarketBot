package ru.ahome.marketbot.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;


public class Settings {
    private DBHelper _dbHelper;

    public static String LOG_TAG = "SETTINGS_LOG";

    public Settings(Context context) {
        _dbHelper = new DBHelper(context);
    }

    public String getSetting(String parameter) {
        String value = null;
        Cursor c = _dbHelper.getWritableDatabase().query("settings", new String[]{"value"}, "parameter = '" + parameter + "'", null, null, null, null);
        if (c.moveToFirst()) {
            value = c.getString(c.getColumnIndex("value"));
        }
        c.close();
        return value;
    }

    public long setSetting(String parameter, String value) {
        long rowID;
        if (getSetting(parameter) == null) {
            ContentValues cv = new ContentValues();
            cv.put("parameter", parameter);
            cv.put("value", value);
            rowID = _dbHelper.getWritableDatabase().insert("settings", null, cv);
        } else {
            ContentValues cv = new ContentValues();
            cv.put("value", value);
            rowID = _dbHelper.getWritableDatabase().update("settings", cv, "parameter = '" + parameter + "'", null);
        }
        return rowID;
    }

    public int deleteAllSettings() {
        Log.d(LOG_TAG, "--- Clear mytable: ---");
        // удаляем все записи
        int clearCount = _dbHelper.getWritableDatabase().delete("settings", null, null);
        Log.d(LOG_TAG, "deleted rows count = " + clearCount);
        return clearCount;
    }
}
