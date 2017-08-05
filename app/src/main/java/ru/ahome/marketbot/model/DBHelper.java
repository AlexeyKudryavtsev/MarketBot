package ru.ahome.marketbot.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static Integer VERSION = 1;
    public static String DB_NAME = "MARKET_BOT";

    public static String LOG_TAG = "DB_LOG";

    private static String CREATE_SETTINGS_TABLE_SQL = "CREATE TABLE `settings` (`id` INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,`parameter` TEXT UNIQUE,`value` TEXT);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "Database create");
        db.execSQL(CREATE_SETTINGS_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(LOG_TAG, "Database update");
    }
}
